import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
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
                result.append(count).append(" - ").append(nombre).append(" ").append(apellido).append(" - ")
                        .append(telefono).append("\n");
            }

            System.out.println(result.toString());

        } catch (SQLException e) {
            System.err.println("Error en la consulta: " + e.getMessage());
        }
    }

    public static void getOrdersByClientId(Connection conn, int id) {
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

    public static void getOrdersByState(Connection conn, String state) {
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
