package strateknuc.lasec.Models;

import java.util.ArrayList;

/**
 * @author AP, SS, LKB, ECS
 */
public class OrderModel {

   private String customerName, customerEmail;
   private double totalPrice;

   // Creates an empty ArrayList productlist
   private ArrayList<ProductModel> productlist = new ArrayList<>();

    /**
     * Empty constructor for Spring
     */
   public OrderModel(){

   }

    // AUTHOR(S): LKB, ECS
    /**
     * addProduct takes a ProductModel and adds it to the the productlist
     * If the product is already in the list the quantity is raised by 1
     * and the price is doubled
     * @param newProduct the product the customer wishes to add to the productlist
     */
    public void addProduct(ProductModel newProduct) {
        for (ProductModel product:productlist) {
            if (newProduct.getEan().equals(product.getEan())) {
                product.setQuantity(product.getQuantity() + 1);
                product.setPrice(product.getPrice() + newProduct.getPrice());
                return;
            }
        }
        productlist.add(new ProductModel(newProduct.getEan(), newProduct.getName(), newProduct.getCategory(),
                newProduct.getManufacturer(), 1, newProduct.getPrice(), newProduct.getDescription()));
        this.setTotalPrice();
    }

    /**
     * clears the productlist and sets the total price to 0
     */
    public void clearOrder() {
        productlist.clear();
        setTotalPrice();
    }

    /**
     * Gets the name of the customer
     * @return The name of the customer
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * Sets the name of a customer
     * @param customerName The name to set it to
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    /**
     * Gets the email of the customer
     * @return The email of the customer
     */
    public String getCustomerEmail() {
        return customerEmail;
    }

    /**
     * Sets the email of a customer
     * @param customerEmail The email to set it to
     */
    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    /**
     * Gets the total price of an order
     * @return The total price of an order
     */
    public double getTotalPrice() {
        return totalPrice;
    }

    // AUTHOR(S): ECS

    /**
     * Sets totalprice to 0 and uses an enhanced for loop to visit every element in the list
     * of products. For every product it adds its price to totalPRice
     */
    public void setTotalPrice(){
        this.totalPrice = 0;

        for (ProductModel products:productlist) {
            this.totalPrice += products.getPrice();
        }
    }

    /**
     * Gets the list of products
     * @return The list of products
     */
    public ArrayList<ProductModel> getProductlist() {
        return productlist;
    }

    /**
     * Sets the list of products
     * @param productlist The list of products to set it to
     */
    public void setProductlist(ArrayList<ProductModel> productlist) {
        this.productlist = productlist;
    }
}

