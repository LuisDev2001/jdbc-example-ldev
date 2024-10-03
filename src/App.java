import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class App {
    private static final String HOST = "127.0.0.1";
    private static final String PORT = "3306";
    private static final String DATABASE = "vivero";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    private static final String ZONE = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";
    private static final String URL = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABASE + ZONE;

    public static void main(String[] args) throws Exception {
        Connection conn = getConnection();
        getClients(conn);
        getOrdersByClientId(conn, 1);
        getOrdersByState(conn, "Entregado");
        CloseConnection(conn);
    }

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            System.err.println("JDBC Driver not found: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Failed to establish connection: " + e.getMessage());
        }
        return null;
    }

    public static void CloseConnection(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
                System.out.println("Connection to MySQL has been closed.");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Error to close connection");
        }
    }

    public static void getClients(Connection conn) {
        String query = "SELECT nombre_contacto, apellido_contacto, telefono FROM cliente";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            
            int count = 0;
            StringBuilder result = new StringBuilder("Clientes:\n");
            
            while (rs.next()) {
                String nombre = rs.getString("nombre_contacto");
                String apellido = rs.getString("apellido_contacto");
                String telefono = rs.getString("telefono");
                count++;
                result.append(count).append(" - ").append(nombre).append(" ").append(apellido).append(" - ").append(telefono).append("\n");
            }
            
            System.out.println(result.toString());
            
        } catch (SQLException e) {
            System.err.println("Error en la consulta: " + e.getMessage());
        }
    }

    public static void getOrdersByClientId (Connection conn, int id) {
        String query = "SELECT id_pedido, fecha_pedido FROM pedido WHERE id_cliente = " + id;
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            StringBuilder result = new StringBuilder("Ordenes del cliente:\n" + id + "\n");
            while (rs.next()) {
                int id_pedido = rs.getInt("id_pedido");
                String fecha_pedido = rs.getString("fecha_pedido");
                result.append(id_pedido).append(" - ").append(fecha_pedido).append("\n");
            }
            System.out.println(result.toString());
        } catch (SQLException e) {
            System.err.println("Error en la consulta: " + e.getMessage());
        }
    }

    public static void getOrdersByState (Connection conn, String state) {
        String query = "SELECT id_pedido, fecha_pedido FROM pedido WHERE estado = " + "'" + state + "'";
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            StringBuilder result = new StringBuilder("Pedidos con estado:\n" + state + "\n");
            while (rs.next()) {
                int id_pedido = rs.getInt("id_pedido");
                String fecha_pedido = rs.getString("fecha_pedido");
                result.append(id_pedido).append(" - ").append(fecha_pedido).append("\n");
            }
            System.out.println(result.toString());
        } catch (SQLException e) {
            System.err.println("Error en la consulta: " + e.getMessage());
        }
    }
}
