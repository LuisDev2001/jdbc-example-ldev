package entity;

public class OrderDetail {
  private int idDetallePedido;
  private int idPedido;
  private int idProducto;
  private int cantidad;
  private double precioUnidad;
  private short numeroLinea;

  // Constructor vacío
  public OrderDetail() {
  }

  // Constructor con parámetros
  public OrderDetail(int idDetallePedido, int idPedido, int idProducto, int cantidad,
      double precioUnidad, short numeroLinea) {
    this.idDetallePedido = idDetallePedido;
    this.idPedido = idPedido;
    this.idProducto = idProducto;
    this.cantidad = cantidad;
    this.precioUnidad = precioUnidad;
    this.numeroLinea = numeroLinea;
  }

  public OrderDetail(int idPedido, int idProducto, int cantidad,
      double precioUnidad, short numeroLinea) {
    this.idPedido = idPedido;
    this.idProducto = idProducto;
    this.cantidad = cantidad;
    this.precioUnidad = precioUnidad;
    this.numeroLinea = numeroLinea;
  }

  // Getters y Setters
  public int getIdDetallePedido() {
    return idDetallePedido;
  }

  public void setIdDetallePedido(int idDetallePedido) {
    this.idDetallePedido = idDetallePedido;
  }

  public int getIdPedido() {
    return idPedido;
  }

  public void setIdPedido(int idPedido) {
    this.idPedido = idPedido;
  }

  public int getIdProducto() {
    return idProducto;
  }

  public void setIdProducto(int idProducto) {
    this.idProducto = idProducto;
  }

  public int getCantidad() {
    return cantidad;
  }

  public void setCantidad(int cantidad) {
    this.cantidad = cantidad;
  }

  public double getPrecioUnidad() {
    return precioUnidad;
  }

  public void setPrecioUnidad(double precioUnidad) {
    this.precioUnidad = precioUnidad;
  }

  public short getNumeroLinea() {
    return numeroLinea;
  }

  public void setNumeroLinea(short numeroLinea) {
    this.numeroLinea = numeroLinea;
  }
}
