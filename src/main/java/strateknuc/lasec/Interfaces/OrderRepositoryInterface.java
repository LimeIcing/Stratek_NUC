package strateknuc.lasec.Interfaces;

import strateknuc.lasec.Models.ProductModel;

import java.util.List;

public interface OrderRepositoryInterface {
    public void addOrderToDatabase(String customer_name, String customer_email, List<ProductModel> productList);
}
