package strateknuc.lasec.Interfaces;

import strateknuc.lasec.Models.ProductModel;

public interface ProductRepositoryInterface
{
    void createProduct(ProductModel p);
    String isProductSaved(int rowsAffected, String productName);
    String getReturnSuccesfully();
}
