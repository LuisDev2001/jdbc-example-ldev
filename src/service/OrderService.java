package service;

import persistance.OrderDAO;
import entity.Order;

public class OrderService {
  private OrderDAO orderDAO;

  public OrderService() {
    orderDAO = new OrderDAO();
  }

  public Order addOrder(int orderId, int orderCode, String dateOrder, String dateWaiting, String dateDelivered,
      String orderState, String comments, int clientId) throws Exception {
    validateOrder(orderId, orderState);
    Order order = new Order();
    order.setIdPedido(orderId);
    order.setCodigoPedido(orderCode);
    order.setFechaPedido(dateOrder);
    order.setFechaEsperada(dateWaiting);
    order.setFechaEntrega(dateDelivered);
    order.setEstado(orderState);
    order.setComentarios(comments);
    order.setIdCliente(clientId);
    orderDAO.createOrder(order);
    System.out.println("Order added");
    return order;
  }

  public void validateOrder(int idCliente, String estado) {
    if (idCliente <= 0) {
      throw new IllegalArgumentException("Client ID must be greater than zero");
    }
    if (estado == null || estado.isEmpty()) {
      throw new IllegalArgumentException("Order state is required");
    }
  }
}
