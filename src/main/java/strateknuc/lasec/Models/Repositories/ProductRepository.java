package strateknuc.lasec.Models.Repositories;

import org.springframework.stereotype.Repository;
import strateknuc.lasec.ConnectionCreator;
import strateknuc.lasec.Interfaces.ProductRepositoryInterface;
import strateknuc.lasec.Models.ProductModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements ProductRepositoryInterface {

    // AUTHOR(S): AP, LKB
    private ConnectionCreator connectionCreator = new ConnectionCreator();

    // AUTHOR(S): AP, LKB, ECS
    @Override
    public void createProduct(ProductModel p) throws Exception {
        // Auto-corrects short EAN numbers
        while (p.getEan().length() < 13) {
            p.setEan("0" + p.getEan());
        }

        System.out.println("creating statement for EAN=" + p.getEan());
        String createString = "INSERT INTO products VALUES(?, ?, ?, ?, ?, ?, ?)";

        System.out.println("getting connection...");
        PreparedStatement preparedStatement = connectionCreator.getConnection().prepareStatement(createString);

        System.out.println("creating product with EAN=" + p.getEan());
        preparedStatement.setString(1,p.getEan());
        preparedStatement.setString(2,p.getManufacturer());
        preparedStatement.setString(3,p.getName());
        preparedStatement.setInt(4,p.getQuantity());
        preparedStatement.setDouble(5,p.getPrice());
        preparedStatement.setString(6,p.getCategory());
        preparedStatement.setString(7,p.getDescription());

        System.out.println("executing...");
        preparedStatement.executeUpdate();

        System.out.println("closing connection...");
        preparedStatement.close();
    }

    // AUTHOR(S): ECS, AP
    @Override
    public void updateProduct(ProductModel p) throws Exception {
        System.out.println("creating update statement for EAN=" + p.getEan());
        String updateString = "UPDATE products SET manufacturer = ?, name = ?, quantity = ?, "
                + "price = ?, category = ?, description = ? WHERE ean = ?";

        System.out.println("getting connection...");
        PreparedStatement preparedStatement = connectionCreator.getConnection().
                prepareStatement(updateString);

        System.out.println("updating product with EAN=" + p.getEan());
        preparedStatement.setString(1,p.getManufacturer());
        preparedStatement.setString(2,p.getName());
        preparedStatement.setInt(3,p.getQuantity());
        preparedStatement.setDouble(4,p.getPrice());
        preparedStatement.setString(5,p.getCategory());
        preparedStatement.setString(6,p.getDescription());
        preparedStatement.setString(7,p.getEan());

        System.out.println("executing...");
        preparedStatement.executeUpdate();

        System.out.println("closing connection...");
        preparedStatement.close();
    }

    // AUTHOR(S): ECS, CPS, LKB
    @Override
    public void deleteProduct(String ean) throws Exception {
        System.out.println("creating delete statement for EAN=" + ean);
        String deleteString = "DELETE FROM products WHERE ean = ?";

        System.out.println("getting connection...");
        PreparedStatement preparedStatement = connectionCreator.getConnection().
                prepareStatement(deleteString);

        System.out.println("deleting product with EAN=" + ean);
        preparedStatement.setString(1, ean);

        System.out.println("executing...");
        preparedStatement.executeUpdate();

        System.out.println("closing connection...");
        preparedStatement.close();
    }


    // AUTHOR(S): LKB
    @Override
    public ProductModel get(String ean) throws Exception{
        System.out.println("creating select statement for EAN=" + ean);
        String getProductString = "SELECT * FROM products WHERE ean = ?";

        System.out.println("getting connection...");
        PreparedStatement preparedStatement = connectionCreator.getConnection().
                prepareStatement(getProductString);


        System.out.println("selecting product with EAN=" + ean);
        preparedStatement.setString(1, ean);
        ResultSet rs = preparedStatement.executeQuery();
        rs.next();
        ProductModel product = new ProductModel(rs.getString(1), rs.getString(3), rs.getString(6),
                rs.getString(2), rs.getInt(4), rs.getDouble(5), rs.getString(7));


        System.out.println("closing resultset...");
        rs.close();

        System.out.println("closing connection...");
        preparedStatement.close();

        return product;
    }

    // AUTHOR(S): LKB, ECS, CPS
    // Returns a list of products from the db
    @Override
    public List<ProductModel> getList(String category) throws Exception {

        List<ProductModel> products = new ArrayList<>();

        System.out.println("creating select statement for product(s) with category=" + category);
        String getProductsString = "SELECT * FROM product_list WHERE category = ?";

        System.out.println("getting connection...");
        PreparedStatement preparedStatement = connectionCreator.getConnection().
                prepareStatement(getProductsString);


        System.out.println("selecting product(s) with category=" + category);
        preparedStatement.setString(1, category);
        ResultSet rs = preparedStatement.executeQuery();

        while (rs.next()) {
            products.add(new ProductModel(rs.getString(1), rs.getDouble(2), rs.getString(4)));
        }

        System.out.println("closing resultset...");
        rs.close();

        System.out.println("closing connection...");
        preparedStatement.close();

        return products;
    }

    // AUTHOR(S): LKB, ECS
    // Returns a list of products from the db
    @Override
    public List<ProductModel> getAdminList() throws Exception {
        List<ProductModel> products = new ArrayList<>();

        System.out.println("creating select statement for all products");
        String getAdminProductsString = "SELECT * FROM product_list_admin";

        System.out.println("getting connection...");
        PreparedStatement preparedStatement = connectionCreator.getConnection().
                prepareStatement(getAdminProductsString);

        System.out.println("selecting all products");
        ResultSet rs = preparedStatement.executeQuery();

        while (rs.next()) {
            products.add(new ProductModel(rs.getString(1), rs.getString(2), rs.getString(5), "",
                    rs.getInt(3), rs.getDouble(4), ""));
        }

        System.out.println("closing resultset...");
        rs.close();

        System.out.println("closing connection...");
        preparedStatement.close();

        return products;
    }
}