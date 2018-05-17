package strateknuc.lasec.Interfaces;

import strateknuc.lasec.Models.ProductModel;

import java.util.List;

//Author: SS, AP, LKB
public interface OrderRepositoryInterface {
    void addOrderToDatabase(String customerName, String customerEmail, List<ProductModel> productList);
}
