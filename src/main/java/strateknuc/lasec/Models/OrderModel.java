package strateknuc.lasec.Models;

import java.util.ArrayList;

/**
 * @author AP, SS, L
 */
// AUTHOR(S): AP, SS, LKB, ECS
public class OrderModel {

   private String customerName, customerEmail;
   private double totalPrice;

   // Creates an empty ArrayList productlist
   private ArrayList<ProductModel> productlist = new ArrayList<>();

   // Empty Constructor
   public OrderModel(){

   }

    /**
     * addProduct takes a ProductModel and adds it to the the productlist
     * If the product is already in the list the quantity is raised by 1
     * and the price is doubled
     * @author ECS LKB
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

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    // AUTHOR(S): ECS
    public void setTotalPrice(){
        this.totalPrice = 0;

        for (ProductModel products:productlist) {
            this.totalPrice += products.getPrice();
        }
    }

    public ArrayList<ProductModel> getProductlist() {
        return productlist;
    }

    public void setProductlist(ArrayList<ProductModel> productlist) {
        this.productlist = productlist;
    }
}

