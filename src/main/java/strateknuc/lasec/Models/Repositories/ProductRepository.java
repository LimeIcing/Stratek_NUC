package strateknuc.lasec.Models.Repositories;

import org.springframework.stereotype.Repository;
import strateknuc.lasec.ConnectionCreator;
import strateknuc.lasec.Interfaces.ProductRepositoryInterface;
import strateknuc.lasec.Models.ProductModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author AP, LKB, ECS, CPS
 */
@Repository
public class ProductRepository implements ProductRepositoryInterface {

    // AUTHOR(S): AP, LKB, ECS

    /**
     * Takes a ProductModel and adds it to the database
     * @param p A ProductModel
     * @return A message based on creation success or failure
     */
    @Override
    public String createProduct(ProductModel p) {
        PreparedStatement preparedStatement = null;

        // Auto-corrects short EAN numbers
        while (p.getEan().length() < 13) {
            p.setEan("0" + p.getEan());
        }

        System.out.println("creating statement for EAN=" + p.getEan());
        String createString = "INSERT INTO products VALUES(?, ?, ?, ?, ?, ?, ?)";

        try {
            System.out.println("getting connection...");
            preparedStatement = ConnectionCreator.getInstance().getConnection().prepareStatement(createString);

            System.out.println("creating product with EAN=" + p.getEan());
            preparedStatement.setString(1, p.getEan());
            preparedStatement.setString(2, p.getManufacturer());
            preparedStatement.setString(3, p.getName());
            preparedStatement.setInt(4, p.getQuantity());
            preparedStatement.setDouble(5, p.getPrice());
            preparedStatement.setString(6, p.getCategory());
            preparedStatement.setString(7, p.getDescription());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String msg;

        try {
            System.out.println("executing...");
            preparedStatement.executeUpdate();
            msg = "Produkt oprettet. Navn: " + p.getName() + ", EAN nr.: " + p.getEan();
        } catch (SQLException e) {
            msg = "Produktet med EAN: " + p.getEan() + " eksisterer allerede og kan derfor ikke oprettes.";
            e.printStackTrace();
        }

        try {
            System.out.println("closing connection...");
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return msg;
    }

    // AUTHOR(S): ECS, AP, LKB

    /**
     * Takes a ProductModel and updates the given product in the database
     * @param p A ProductModel
     */
    @Override
    public void updateProduct(ProductModel p) {
        System.out.println("creating update statement for EAN=" + p.getEan());
        String updateString = "UPDATE products SET manufacturer = ?, name = ?, quantity = ?, "
                + "price = ?, category = ?, description = ? WHERE ean = ?";
        PreparedStatement preparedStatement = null;

        try {
            System.out.println("getting connection...");
            preparedStatement = ConnectionCreator.getInstance().getConnection().prepareStatement(updateString);

            System.out.println("updating product with EAN=" + p.getEan());
            preparedStatement.setString(1, p.getManufacturer());
            preparedStatement.setString(2, p.getName());
            preparedStatement.setInt(3, p.getQuantity());
            preparedStatement.setDouble(4, p.getPrice());
            preparedStatement.setString(5, p.getCategory());
            preparedStatement.setString(6, p.getDescription());
            preparedStatement.setString(7, p.getEan());

            System.out.println("executing...");
            preparedStatement.executeUpdate();

            System.out.println("closing connection...");
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // AUTHOR(S): ECS, CPS, LKB

    /**
     * Takes a ean number and deletes the product in the database
     * with a matching ean number
     * @param ean The ean number of the product to delete in the database
     */
    @Override
    public void deleteProduct(String ean) {
        System.out.println("creating delete statement for EAN=" + ean);
        String deleteString = "DELETE FROM products WHERE ean = ?";
        PreparedStatement preparedStatement = null;

        try {
            System.out.println("getting connection...");
            preparedStatement = ConnectionCreator.getInstance().getConnection().prepareStatement(deleteString);

            System.out.println("deleting product with EAN=" + ean);
            preparedStatement.setString(1, ean);

            System.out.println("executing...");
            preparedStatement.executeUpdate();

            System.out.println("closing connection...");
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // AUTHOR(S): LKB

    /**
     * Takes a ean number and returns the product from the database
     * with a matching ean number
     * @param ean The ean number of the product to retrieve
     * @return A ProductModel of the of the product in the database
     * that matches the ean number of the parameter
     */
    @Override
    public ProductModel get(String ean) {
        System.out.println("creating select statement for EAN=" + ean);
        String getProductString = "SELECT * FROM products WHERE ean = ?";
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        ProductModel product = null;

        try {
            System.out.println("getting connection...");
            preparedStatement = ConnectionCreator.getInstance().getConnection().prepareStatement(getProductString);

            System.out.println("selecting product with EAN=" + ean);
            preparedStatement.setString(1, ean);
            rs = preparedStatement.executeQuery();
            rs.next();
            product = new ProductModel(rs.getString(1), rs.getString(3), rs.getString(6),
                    rs.getString(2), rs.getInt(4), rs.getDouble(5), rs.getString(7));

            System.out.println("closing resultset...");
            rs.close();

            System.out.println("closing connection...");
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return product;
    }

    // AUTHOR(S): LKB, ECS, CPS
    /**
     * Gets a list of products from the database which has the same category
     * as the parameter
     * @param category The category name of the products to retrieve
     * @return a list of products
     */
    @Override
    public List<ProductModel> getList(String category) {
        List<ProductModel> products = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

        System.out.println("creating select statement for product(s) with category=" + category);
        String getProductsString = "SELECT * FROM product_list WHERE category = ?";

        try {
            System.out.println("getting connection...");
            preparedStatement = ConnectionCreator.getInstance().getConnection().prepareStatement(getProductsString);

            System.out.println("selecting product(s) with category=" + category);
            preparedStatement.setString(1, category);
            rs = preparedStatement.executeQuery();

            while (rs.next()) {
                products.add(new ProductModel(rs.getString(1), rs.getDouble(2), rs.getString(4)));
            }

            System.out.println("closing resultset...");
            rs.close();

            System.out.println("closing connection...");
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return products;
    }

    // AUTHOR(S): LKB, ECS
    /**
     * Gets a list of all products in the database
     * @return a list of products
     */
    @Override
    public List<ProductModel> getAdminList() {
        List<ProductModel> products = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

        System.out.println("creating select statement for all products");
        String getAdminProductsString = "SELECT * FROM product_list_admin";

        try {
            System.out.println("getting connection...");
            preparedStatement = ConnectionCreator.getInstance().getConnection().prepareStatement(getAdminProductsString);

            System.out.println("selecting all products");
            rs = preparedStatement.executeQuery();

            while (rs.next()) {
                products.add(new ProductModel(rs.getString(1), rs.getString(2), rs.getString(5),
                        "", rs.getInt(3), rs.getDouble(4), ""));
            }

            System.out.println("closing resultset...");
            rs.close();

            System.out.println("closing connection...");
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return products;
    }
}