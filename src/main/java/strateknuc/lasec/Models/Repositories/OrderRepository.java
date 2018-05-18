package strateknuc.lasec.Models.Repositories;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import strateknuc.lasec.Interfaces.OrderRepositoryInterface;
import strateknuc.lasec.Models.ProductModel;

import java.util.List;

@Repository
public class OrderRepository implements OrderRepositoryInterface {

    private JdbcTemplate jdbc;

    // AUTHOR(S): ECS
    @Override
    public void addOrderToDatabase(String customerName, String customerEmail, List<ProductModel> productList) {
        System.out.println(customerName + "-" + customerEmail);

        String insertOrderIntoDb = "INSERT INTO orders(customer_name, customer_email) " +
                "VALUE('" + customerName + "', '" + customerEmail + "')";

        jdbc.update(insertOrderIntoDb);

        // Gets the newly created order's ID back from the db
        String getOrderIdFromDb = "SELECT id FROM orders " +
                "WHERE customer_email = '" + customerEmail + "' " +
                "AND customer_name = '" + customerName + "' " +
                "ORDER BY id DESC LIMIT 1";

        int orderId = jdbc.update(getOrderIdFromDb);

        String insertIntoProductOrder = "";

        for (ProductModel product : productList) {
            insertIntoProductOrder = "INSERT INTO products_orders(order_id, product_ean, quantity) " +
                    "VALUE("+ orderId + ", '" + product.getEan() + "', " + product.getQuantity() + ")";
            jdbc.update(insertIntoProductOrder);
        }


    }
}
