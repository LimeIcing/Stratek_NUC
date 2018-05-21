package strateknuc.lasec.Models.Repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;
import strateknuc.lasec.ConnectionCreator;
import strateknuc.lasec.Interfaces.ProductRepositoryInterface;
import strateknuc.lasec.Models.ProductModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements ProductRepositoryInterface {

    // AUTHOR: AP, LKB
    @Autowired
    private JdbcTemplate jdbc;

    ConnectionCreator connectionCreator = new ConnectionCreator();

    private String returnSuccesfully;

    // AUTHOR(S): AP, LKB, ECS
    @Override
    public void createProduct(ProductModel p) {

        // Auto-corrects short EAN numbers
        while (p.getEan().length() < 13) {
            p.setEan("0" + p.getEan());
        }

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

    // AUTHOR(S): ECS, AP
    @Override
    public void updateProduct(ProductModel p) throws Exception {

        System.out.println("creating statement");
        String updateString = "UPDATE products SET manufacturer = ?, name = ?, quantity = ?, "
                + "price = ?, category = ?, description = ? WHERE ean = ?";

        System.out.println("getting connection");
        PreparedStatement preparedStatement = connectionCreator.getConnection().
                prepareStatement(updateString);

        System.out.println("updating statement");
        preparedStatement.setString(1,p.getManufacturer());
        preparedStatement.setString(2,p.getName());
        preparedStatement.setInt(3,p.getQuantity());
        preparedStatement.setDouble(4,p.getPrice());
        preparedStatement.setString(5,p.getCategory());
        preparedStatement.setString(6,p.getDescription());
        preparedStatement.setString(7,p.getEan());

        System.out.println("executing");
        preparedStatement.executeUpdate();
        System.out.println("closing connection");
        preparedStatement.close();
    }

    // AUTHOR(S): ECS, CPS
    @Override
    public void deleteProduct(String ean) {

        String sql = "DELETE FROM products " +
                "WHERE ean = '" + ean + "'";

        jdbc.update(sql);
    }

    // AUTHOR: AP,LKB
    @Override
    public String isProductSaved(int rowsAffected, String productName) {

        if(rowsAffected != 1) {
            return productName + "was not created, try again";
        }
        // integrate with SQLException
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

        ProductModel product = new ProductModel(rs.getString(1), rs.getString(3), rs.getString(6),
                rs.getString(2), rs.getInt(4), rs.getDouble(5), rs.getString(7));

        return product;
    }

    // AUTHOR(S): LKB, ECS, CPS
    // Returns a list of products from the db
    @Override
    public List<ProductModel> getList(String category) {

        List<ProductModel> products = new ArrayList<>();

        String sql = "SELECT * FROM product_list WHERE category = '" + category + "'";

        SqlRowSet rs = jdbc.queryForRowSet(sql);

        while (rs.next()) {
            products.add(new ProductModel(rs.getString(1), rs.getDouble(2), rs.getString(4)));
        }

        return products;
    }

    // AUTHOR(S): LKB, ECS
    // Returns a list of products from the db
    @Override
    public List<ProductModel> getAdminList() {

        List<ProductModel> products = new ArrayList<>();

        String sql = "SELECT * FROM product_list_admin";

        SqlRowSet rs = jdbc.queryForRowSet(sql);

        while (rs.next()) {
            products.add(new ProductModel(rs.getString(1), rs.getString(2), rs.getString(5), "",
                    rs.getInt(3), rs.getDouble(4), ""));
        }

        return products;
    }
}
