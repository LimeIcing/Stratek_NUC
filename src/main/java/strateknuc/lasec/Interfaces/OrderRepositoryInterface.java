package strateknuc.lasec.Interfaces;

import strateknuc.lasec.Models.ProductModel;
import strateknuc.lasec.Models.ProductOrderModel;
import java.util.List;

//Author: SS, AP, LKB
public interface OrderRepositoryInterface {
    void addOrderToDatabase(String customerName, String customerEmail, List<ProductModel> productList);
    List<ProductOrderModel> getOrdersFromDatabase();
}
