package strateknuc.lasec.Interfaces;

import strateknuc.lasec.Models.ProductModel;

import java.util.List;

public interface ProductRepositoryInterface {

    void createProduct(ProductModel p);
    void updateProduct(ProductModel p);
    void deleteProduct(ProductModel p);
    String isProductSaved(int rowsAffected, String productName);
    ProductModel get(String ean);
    List<ProductModel> getAdminList();
    List<ProductModel> getList(String category);

}
