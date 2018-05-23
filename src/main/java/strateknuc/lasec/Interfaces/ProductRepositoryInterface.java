package strateknuc.lasec.Interfaces;

import strateknuc.lasec.Models.ProductModel;
import java.util.List;

public interface ProductRepositoryInterface {
    String createProduct(ProductModel p) throws Exception;
    void updateProduct(ProductModel p) throws Exception;
    void deleteProduct(String ean) throws Exception;
    ProductModel get(String ean) throws Exception;
    List<ProductModel> getAdminList() throws Exception;
    List<ProductModel> getList(String category) throws Exception;
}
