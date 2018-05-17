package strateknuc.lasec.Models.Repositories;

import org.springframework.stereotype.Repository;
import strateknuc.lasec.Interfaces.OrderRepositoryInterface;
import strateknuc.lasec.Models.ProductModel;

import java.util.List;

@Repository
public class OrderRepository implements OrderRepositoryInterface {

    @Override
    public void addOrderToDatabase(List<ProductModel> productList) {

    }
}
