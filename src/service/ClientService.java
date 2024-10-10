package service;

import java.util.List;
import entity.Client;
import persistance.ClientDAO;

/**
 * ClientService
 */
public class ClientService {
  private ClientDAO clientDAO;

  public ClientService() {
    clientDAO = new ClientDAO();
  }

  public Client addClient(int codigoCliente, String nombreCliente, String nombreContacto, String apellidoContacto,
      String telefono, String fax, String ciudad, String region, String pais, String codigoPostal, int idEmpleado,
      double limiteCredito) throws Exception {
    validateClient(nombreCliente, nombreContacto);
    Client client = new Client();
    client.setCodigoCliente(codigoCliente);
    client.setNombreCliente(nombreCliente);
    client.setNombreContacto(nombreContacto);
    client.setApellidoContacto(apellidoContacto);
    client.setTelefono(telefono);
    client.setFax(fax);
    client.setCiudad(ciudad);
    client.setRegion(region);
    client.setPais(pais);
    client.setCodigoPostal(codigoPostal);
    client.setIdEmpleado(idEmpleado);
    client.setLimiteCredito(limiteCredito);
    clientDAO.createClient(client);
    System.out.println("Client added");
    return client;
  }

  public void validateClient(String clientName, String clientContactName) {
    if (clientName == null || clientName.isEmpty()) {
      throw new IllegalArgumentException("Client name and contact name are required");
    }
    if (clientContactName == null || clientContactName.isEmpty()) {
      throw new IllegalArgumentException("Client contact name is required");
    }
  }

  public List<Client> listClients() throws Exception {
    List<Client> clients = clientDAO.getClients();
    System.out.println("Clients listed");
    return clients;
  }

  public Client getClientById(int idClient) throws Exception {
    Client client = clientDAO.searchClientById(idClient);
    System.out.println("Client found");
    return client;
  }
}