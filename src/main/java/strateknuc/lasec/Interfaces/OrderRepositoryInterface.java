package strateknuc.lasec.Interfaces;

import strateknuc.lasec.Models.ProductModel;

import java.util.List;

public interface OrderRepositoryInterface {
    public void addOrderToDatabase(List<ProductModel> productList);
}
