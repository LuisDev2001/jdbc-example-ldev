import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
}
