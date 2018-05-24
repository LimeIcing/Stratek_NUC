package strateknuc.lasec.Interfaces;

import strateknuc.lasec.Models.ProductModel;
import strateknuc.lasec.Models.ProductOrderModel;
import java.util.List;

/**
 * Interface that is implemented in OrderRepository
 * Check OrderRepository for method descriptions
 * @author SS, AP, LKB
 */
public interface OrderRepositoryInterface {
    void addOrderToDatabase(String customerName, String customerEmail, List<ProductModel> productList);
    List<ProductOrderModel> getOrdersFromDatabase();
}
