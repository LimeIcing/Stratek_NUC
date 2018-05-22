package strateknuc.lasec.Interfaces;

import strateknuc.lasec.Models.ProductModel;

import java.util.List;

public interface ProductRepositoryInterface {

    void createProduct(ProductModel p) throws Exception;
    void updateProduct(ProductModel p) throws Exception;
    void deleteProduct(String ean) throws Exception;
    ProductModel get(String ean);
    List<ProductModel> getAdminList();
    List<ProductModel> getList(String category);

}
