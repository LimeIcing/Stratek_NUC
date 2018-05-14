package strateknuc.lasec.Models.Repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;
import strateknuc.lasec.Interfaces.ProductRepositoryInterface;
import strateknuc.lasec.Models.ProductModel;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements ProductRepositoryInterface {

    //AUTHOR: AP, LKB
    @Autowired
    private JdbcTemplate jdbc;

    private String returnSuccesfully;

    //AUTHOR: AP, LKB
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
            returnSuccesfully = isProductSaved(rowsAffected,p.getName());
            System.out.println("Rows affected: " + rowsAffected);
    }

    //AUTHOR: AP,LKB
    @Override
    public String isProductSaved(int rowsAffected, String productName) {

        if(rowsAffected != 1) {
            return productName + "was not created, try again";
        }
        //integrate with SQLException
        else{
            return productName + " was created successfully ";
        }
    }

    //AUTHOR: LKB
    @Override
    public ProductModel get(String ean){

        String sql = "SELECT * FROM products WHERE ean = " + ean;

        SqlRowSet rs = jdbc.queryForRowSet(sql);

        rs.next();

        // public ProductModel(String ean, String name, String category, String manufacturer, int quantity, double price,
        //                        String description)

        ProductModel product = new ProductModel(rs.getString(1), rs.getString(3), rs.getString(6),
                rs.getString(2), rs.getInt(4), rs.getDouble(5), rs.getString(7));

        return product;
    }

    // AUTHOR: LKB
    public List<ProductModel> get() {

        List<ProductModel> products = new ArrayList<>();

        String sql = "SELECT * FROM products";

        SqlRowSet rs = jdbc.queryForRowSet(sql);

        while (rs.next()) {
            products.add(new ProductModel(rs.getString(1), rs.getString(3), rs.getString(6),
                    rs.getString(2), rs.getInt(4), rs.getDouble(5), rs.getString(7)));
        }
        return products;
    }
}
