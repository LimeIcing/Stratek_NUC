package strateknuc.lasec.Models.Repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;
import strateknuc.lasec.Interfaces.OrderRepositoryInterface;
import strateknuc.lasec.Models.ProductModel;
import strateknuc.lasec.Models.ProductOrderModel;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderRepository implements OrderRepositoryInterface {

    @Autowired
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


        SqlRowSet rs = jdbc.queryForRowSet(getOrderIdFromDb);
        rs.next();
        int orderId = rs.getInt(1);

        String insertIntoProductOrder = "";

        for (ProductModel product : productList) {
            insertIntoProductOrder = "INSERT INTO product_orders(order_id, product_ean, quantity) " +
                    "VALUE("+ orderId + ", '" + product.getEan() + "', " + product.getQuantity() + ")";
            jdbc.update(insertIntoProductOrder);
        }
    }

    // LKB
    // Retrieves a list of orders from the database
    @Override
    public List<ProductOrderModel> getOrdersFromDatabase() {

        List<ProductOrderModel> orders = new ArrayList<>();

        String sql = "SELECT product_orders.order_id, date, customer_name, customer_email, product_orders.product_ean " +
                "FROM orders " +
                "FULL JOIN product_orders ON id=product_orders.order_id " +
                "ORDER BY id";

        SqlRowSet rs = jdbc.queryForRowSet(sql);

        while (rs.next()) {
            orders.add(new ProductOrderModel(rs.getInt(1), rs.getDate(2), rs.getString(3),
                    rs.getString(4), rs.getString(5)));
        }
        return orders;
    }
}
