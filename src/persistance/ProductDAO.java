package persistance;

public class ProductDAO extends DAO {
  public void DeleteProduct(int idProduct) throws Exception {
    String query = "DELETE FROM producto WHERE id_producto = " + idProduct;
    createEditDeleteFromDB(query);
    System.out.println("Product has been deleted.");
  }
}
