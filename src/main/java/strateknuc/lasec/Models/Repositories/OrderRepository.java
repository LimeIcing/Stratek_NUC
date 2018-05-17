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

        // Gets the newly created order's ID back from the db
        String getOrderFromDb = "SELECT id FROM orders " +
                "WHERE customer_email = '" + customerEmail + "' " +
                "AND customer_name = '" + customerName + "' " +
                "ORDER BY id DESC LIMIT 1";

        jdbc.update(getOrderFromDb);

        /*
        to add an order to DB
        ---ORDER---
        int id, String customerName, String customerEmail, date

        INSERT INTO orders VALUES(customerName, customerEmail)


        ---PRODUCT_ORDERS---

        SELECT ID FROM ORDERS WHERE CUSTOMER

         */

    }
}
