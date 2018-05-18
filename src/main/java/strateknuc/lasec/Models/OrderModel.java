package strateknuc.lasec.Models;

import java.util.ArrayList;

// AP, SS, LKB, ECS
public class OrderModel {
   private String customerName;
   private String customerEmail;

   private double totalprice;

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

    public double getTotalprice() {
        return totalprice;
    }

    // AUTHOR(S): ECS
    public void setTotalPrice(){
        this.totalprice = 0;

        for (ProductModel products:productlist) {
            this.totalprice += products.getPrice();
        }
    }

    public ArrayList<ProductModel> getProductlist() {
        return productlist;
    }
}
