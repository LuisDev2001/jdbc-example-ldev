package entity;

public class Order {
  private int idPedido;
  private int codigoPedido;
  private String fechaPedido; // Puedes usar LocalDate si prefieres trabajar con fechas en Java
  private String fechaEsperada;
  private String fechaEntrega;
  private String estado;
  private String comentarios;
  private int idCliente;

  // Constructor vacío
  public Order() {
  }

  // Constructor con parámetros
  public Order(int idPedido, int codigoPedido, String fechaPedido, String fechaEsperada,
      String fechaEntrega, String estado, String comentarios, int idCliente) {
    this.idPedido = idPedido;
    this.codigoPedido = codigoPedido;
    this.fechaPedido = fechaPedido;
    this.fechaEsperada = fechaEsperada;
    this.fechaEntrega = fechaEntrega;
    this.estado = estado;
    this.comentarios = comentarios;
    this.idCliente = idCliente;
  }

  public Order(int codigoPedido, String fechaPedido, String fechaEsperada,
      String fechaEntrega, String estado, String comentarios, int idCliente) {
    this.codigoPedido = codigoPedido;
    this.fechaPedido = fechaPedido;
    this.fechaEsperada = fechaEsperada;
    this.fechaEntrega = fechaEntrega;
    this.estado = estado;
    this.comentarios = comentarios;
    this.idCliente = idCliente;
  }

  // Getters y Setters
  public int getIdPedido() {
    return idPedido;
  }

  public void setIdPedido(int idPedido) {
    this.idPedido = idPedido;
  }

  public int getCodigoPedido() {
    return codigoPedido;
  }

  public void setCodigoPedido(int codigoPedido) {
    this.codigoPedido = codigoPedido;
  }

  public String getFechaPedido() {
    return fechaPedido;
  }

  public void setFechaPedido(String fechaPedido) {
    this.fechaPedido = fechaPedido;
  }

  public String getFechaEsperada() {
    return fechaEsperada;
  }

  public void setFechaEsperada(String fechaEsperada) {
    this.fechaEsperada = fechaEsperada;
  }

  public String getFechaEntrega() {
    return fechaEntrega;
  }

  public void setFechaEntrega(String fechaEntrega) {
    this.fechaEntrega = fechaEntrega;
  }

  public String getEstado() {
    return estado;
  }

  public void setEstado(String estado) {
    this.estado = estado;
  }

  public String getComentarios() {
    return comentarios;
  }

  public void setComentarios(String comentarios) {
    this.comentarios = comentarios;
  }

  public int getIdCliente() {
    return idCliente;
  }

  public void setIdCliente(int idCliente) {
    this.idCliente = idCliente;
  }
}
