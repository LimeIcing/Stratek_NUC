package strateknuc.lasec.Models;

import java.util.ArrayList;

// AP, SS, LKB, ECS
public class OrderModel {
   private String customerName;
   private String customerEmail;

   private double totalPrice;

   private ArrayList<ProductModel> productlist = new ArrayList<>();

   public OrderModel(){}

    public OrderModel(String customerName, String customerEmail) {
        this.customerName = customerName;
        this.customerEmail = customerEmail;
    }

    // AUTHOR(S):
    public void addProduct(ProductModel productModel) {
        productlist.add(productModel);
    }

    public void clearOrder()
    {
        productlist.clear();
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
}
