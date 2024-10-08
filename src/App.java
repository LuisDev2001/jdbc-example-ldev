import java.util.List;
import entity.Client;
import entity.Order;
import persistance.ClientDAO;
import persistance.ProductDAO;
import persistance.OrderDAO;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        // ClientDAO clientDAO = new ClientDAO();
        // clientDAO.createClient(new Client(20, "Dina", "Abismael", "Gonzalez",
        // "1234567890", "1234567890", "CDMX",
        // "CDMX", "Mexico", "12345", 1, 1000.00));

        // clientDAO.createClient(new Client(21, "Empresa ABC", "Carlos", "Martinez",
        // "0987654321", "0987654321",
        // "Guadalajara", "Jalisco", "Mexico", "54321", 2, 5000.00));

        // List<Client> myClients = clientDAO.getClients();

        // System.out.println("Clients:");
        // if (myClients != null) {
        // for (Client client : myClients) {
        // System.out.println(client.getIdCliente() + " " + client.getNombreCliente() +
        // " " + client.getPais());
        // }
        // }

        // Client client = clientDAO.searchClientById(1);
        // if (client != null) {
        // System.out.println(client.getIdCliente() + " " + client.getNombreCliente() +
        // " " + client.getPais());
        // }

        // ProductDAO productDAO = new ProductDAO();
        // productDAO.DeleteProduct(50);

        OrderDAO orderDAO = new OrderDAO();
        List<Order> orders = orderDAO.GetOrderDetails(5);
        List<Order> ordersRejected = orderDAO.GetOrderByState("Rechazado");

        if (orders != null) {
            System.out.println("Orders:");
            for (Order order : orders) {
                System.out.println(order.getIdPedido() + " " + order.getIdCliente() + " " + order.getEstado() + " "
                        + order.getComentarios());
            }
        }

        System.out.println("-------------------");

        if (ordersRejected != null) {
            System.out.println("Orders rejected:");
            for (Order order : ordersRejected) {
                System.out.println(order.getIdPedido() + " " + order.getIdCliente() + " " + order.getEstado() + " "
                        + order.getComentarios());
            }

        }
    }
}
