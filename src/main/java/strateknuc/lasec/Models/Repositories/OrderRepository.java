package strateknuc.lasec.Models.Repositories;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import strateknuc.lasec.Interfaces.OrderRepositoryInterface;
import strateknuc.lasec.Models.ProductModel;

import java.util.List;

@Repository
public class OrderRepository implements OrderRepositoryInterface {

    private JdbcTemplate jdbc;

    @Override
    public void addOrderToDatabase(String customer_name, String customer_email, List<ProductModel> productList) {


    }
}
