package persistance;

import java.util.ArrayList;
import java.util.List;
import entity.Order;

public class OrderDAO extends DAO {
  public List<Order> GetOrderDetails(int idOrder) throws Exception {
    // Get order details
    List<Order> orders = new ArrayList<>();
    String query = "SELECT * FROM pedido WHERE id_cliente = " + idOrder;

    try {
      readFromDB(query);
      while (resultSet.next()) {
        Order order = new Order();
        order.setIdPedido(resultSet.getInt("id_pedido"));
        order.setIdCliente(resultSet.getInt("id_cliente"));
        order.setEstado(resultSet.getString("estado"));
        order.setComentarios(resultSet.getString("comentarios"));
        orders.add(order);
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
    } finally {
      CloseConnection();
    }

    return orders;
  }

  public List<Order> GetOrderByState(String state) throws Exception {
    // Get order details by state
    List<Order> orders = new ArrayList<>();
    String query = "SELECT * FROM pedido WHERE estado = '" + state + "'";

    try {
      readFromDB(query);
      while (resultSet.next()) {
        Order order = new Order();
        order.setIdPedido(resultSet.getInt("id_pedido"));
        order.setIdCliente(resultSet.getInt("id_cliente"));
        order.setEstado(resultSet.getString("estado"));
        order.setComentarios(resultSet.getString("comentarios"));
        orders.add(order);
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
    } finally {
      CloseConnection();
    }

    return orders;
  }

  public void createOrder(Order order) throws Exception {
    if (order == null) {
      System.out.println("Order is null.");
      return;
    }
    // Create a new order
    // Insert the order into the database
    String query = "INSERT INTO pedido (id_pedido, codigo_pedido, fecha_pedido, fecha_esperada, fecha_entrega, estado, comentarios, id_cliente) "
        +
        "VALUES (" +
        order.getIdPedido() + ", " +
        order.getCodigoPedido() + ", '" +
        order.getFechaPedido() + "', '" +
        order.getFechaEsperada() + "', '" +
        order.getFechaEntrega() + "', '" +
        order.getEstado() + "', '" +
        order.getComentarios() + "', " +
        order.getIdCliente() + ")";

    System.out.println(query);

    createEditDeleteFromDB(query);
    System.out.println("Order has been created.");
  }
}
