package persistance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAO {
  protected Connection conn = null;
  protected ResultSet resultSet = null;
  protected Statement statement = null;
  private static final String HOST = "127.0.0.1";
  private static final String PORT = "3306";
  private static final String DATABASE = "vivero";
  private static final String USER = "root";
  private static final String PASSWORD = "root";
  private static final String ZONE = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";
  private static final String URL = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABASE + ZONE;

  protected void OpenConnection() {
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      System.out.println("Conexión exitosa a la base de datos.");
      conn = DriverManager.getConnection(URL, USER, PASSWORD);
    } catch (ClassNotFoundException e) {
      System.err.println("JDBC Driver not found: " + e.getMessage());
    } catch (SQLException e) {
      System.err.println("Failed to establish connection: " + e.getMessage());
    }
  }

  protected void CloseConnection() throws SQLException, ClassNotFoundException {
    try {
      if (resultSet != null) {
        resultSet.close();
      }
      if (statement != null) {
        statement.close();
      }
      if (conn != null) {
        conn.close();
        System.out.println("Connection to MySQL has been closed.");
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
      throw e;
    }
  }

  protected void createEditDeleteFromDB(String query) throws Exception {
    try {
      OpenConnection();
      statement = conn.createStatement();
      statement.executeUpdate(query);
    } catch (SQLException ex) {
      System.out.println(ex.getMessage());
      throw ex;
    } finally {
      CloseConnection();
    }
  }

  protected void readFromDB(String query) throws Exception {
    try {
      OpenConnection();
      statement = conn.createStatement();
      resultSet = statement.executeQuery(query);
    } catch (SQLException ex) {
      System.out.println(ex.getMessage());
      throw ex;
    }
  }
}
