package entity;

public class RangeProduct {
  private int idGama;
  private String gama;
  private String descripcionTexto;
  private String descripcionHtml;
  private String imagen;

  // Constructor vacío
  public RangeProduct() {
  }

  // Constructor con parámetros
  public RangeProduct(int idGama, String gama, String descripcionTexto, String descripcionHtml, String imagen) {
    this.idGama = idGama;
    this.gama = gama;
    this.descripcionTexto = descripcionTexto;
    this.descripcionHtml = descripcionHtml;
    this.imagen = imagen;
  }

  public RangeProduct(String gama, String descripcionTexto, String descripcionHtml, String imagen) {
    this.gama = gama;
    this.descripcionTexto = descripcionTexto;
    this.descripcionHtml = descripcionHtml;
    this.imagen = imagen;
  }

  // Getters y Setters
  public int getIdGama() {
    return idGama;
  }

  public void setIdGama(int idGama) {
    this.idGama = idGama;
  }

  public String getGama() {
    return gama;
  }

  public void setGama(String gama) {
    this.gama = gama;
  }

  public String getDescripcionTexto() {
    return descripcionTexto;
  }

  public void setDescripcionTexto(String descripcionTexto) {
    this.descripcionTexto = descripcionTexto;
  }

  public String getDescripcionHtml() {
    return descripcionHtml;
  }

  public void setDescripcionHtml(String descripcionHtml) {
    this.descripcionHtml = descripcionHtml;
  }

  public String getImagen() {
    return imagen;
  }

  public void setImagen(String imagen) {
    this.imagen = imagen;
  }
}
