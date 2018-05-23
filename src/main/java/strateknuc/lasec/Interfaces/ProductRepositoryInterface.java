package strateknuc.lasec.Interfaces;

import strateknuc.lasec.Models.ProductModel;
import java.util.List;

public interface ProductRepositoryInterface {
    String createProduct(ProductModel p);
    void updateProduct(ProductModel p);
    void deleteProduct(String ean);
    ProductModel get(String ean);
    List<ProductModel> getAdminList();
    List<ProductModel> getList(String category);
}
