package persistance;

import java.util.ArrayList;
import java.util.List;

import entity.Client;

public class ClientDAO extends DAO {

  public void createClient(Client client) throws Exception {
    if (client == null) {
      System.out.println("Client is null.");
      return;
    }
    // Create a new client
    // Insert the client into the database
    String query = "INSERT INTO cliente (codigo_cliente, nombre_cliente, nombre_contacto, apellido_contacto, telefono, fax, ciudad, region, pais, codigo_postal, id_empleado, limite_credito) "
        +
        "VALUES (" +
        client.getCodigoCliente() + ", '" +
        client.getNombreCliente() + "', '" +
        client.getNombreContacto() + "', '" +
        client.getApellidoContacto() + "', '" +
        client.getTelefono() + "', '" +
        client.getFax() + "', '" +
        client.getCiudad() + "', '" +
        client.getRegion() + "', '" +
        client.getPais() + "', '" +
        client.getCodigoPostal() + "', " +
        client.getIdEmpleado() + ", " +
        client.getLimiteCredito() + ")";

    createEditDeleteFromDB(query);
    System.out.println("Client has been created.");
  }

  public List<Client> getClients() throws Exception {
    // Read all clients
    String query = "SELECT id_cliente, nombre_cliente, pais FROM cliente";
    readFromDB(query);
    List<Client> clients = new ArrayList<>();
    try {
      while (resultSet.next()) {
        Client client = new Client();
        client.setIdCliente(resultSet.getInt("id_cliente"));
        client.setNombreCliente(resultSet.getString("nombre_cliente"));
        client.setPais(resultSet.getString("pais"));
        clients.add(client);
      }
      return clients;
    } catch (Exception e) {
      System.out.println(e.getMessage());
    } finally {
      CloseConnection();
    }
    return null;
  }

  public Client searchClientById(int idClient) throws Exception {
    // Search a client by id
    String query = "SELECT * FROM cliente WHERE id_cliente = " + idClient;
    readFromDB(query);
    try {
      if (resultSet.next()) {
        Client client = new Client();
        client.setIdCliente(resultSet.getInt("id_cliente"));
        client.setCodigoCliente(resultSet.getInt("codigo_cliente"));
        client.setNombreCliente(resultSet.getString("nombre_cliente"));
        client.setNombreContacto(resultSet.getString("nombre_contacto"));
        client.setApellidoContacto(resultSet.getString("apellido_contacto"));
        client.setTelefono(resultSet.getString("telefono"));
        client.setFax(resultSet.getString("fax"));
        client.setCiudad(resultSet.getString("ciudad"));
        client.setRegion(resultSet.getString("region"));
        client.setPais(resultSet.getString("pais"));
        client.setCodigoPostal(resultSet.getString("codigo_postal"));
        client.setIdEmpleado(resultSet.getInt("id_empleado"));
        client.setLimiteCredito(resultSet.getDouble("limite_credito"));
        return client;
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
    } finally {
      CloseConnection();
    }
    return null;
  }
}
