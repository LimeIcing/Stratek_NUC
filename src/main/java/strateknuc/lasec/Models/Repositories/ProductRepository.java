package strateknuc.lasec.Models.Repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import strateknuc.lasec.Interfaces.ProductRepositoryInterface;
import strateknuc.lasec.Models.ProductModel;

@Repository
public class ProductRepository implements ProductRepositoryInterface {

    @Autowired
    private JdbcTemplate jdbc;

    @Override
    public void createProduct(ProductModel p) {

        // Update with SQL tables - sync if anything changes (task)
        String sql = "INSERT INTO products( ean, manufacturer, name, quantity, price, category, description) " +
                "VALUES('" + p.getEan() + "', '"
                + p.getManufacturer() + "', '" +
                p.getName() + "', " +
                p.getQuantity() + ", " +
                p.getPrice() + ", '" +
                p.getCategory() + "', '" +
                p.getDescription() + "')";

            int rowsAffected = jdbc.update(sql);
            System.out.println("Rows affected: " + rowsAffected);
    }
}
