package strateknuc.lasec.Interfaces;

import strateknuc.lasec.Models.ProductModel;

import java.util.List;

//Author: SS, AP, LKB
public interface OrderRepositoryInterface {
    public void addOrderToDatabase(String customer_name, String customer_email, List<ProductModel> productList);
}
