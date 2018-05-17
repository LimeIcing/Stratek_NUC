package strateknuc.lasec.Models;

import java.util.ArrayList;

// AP,SS, LKB
public class OrderModel {
   private String customer_name;
   private String customer_email;

   private double totalprice;

   ArrayList<ProductModel> productlist = new ArrayList<>();

    public OrderModel(String customer_name, String customer_email) {
        this.customer_name = customer_name;
        this.customer_email = customer_email;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getCustomer_email() {
        return customer_email;
    }

    public void setCustomer_email(String customer_email) {
        this.customer_email = customer_email;
    }
    public  void addProduct(ProductModel productModel){
        productlist.add(productModel);
    }

    public void setTotalPrice(){
        if (productlist== null)
            return;
        for (ProductModel products:productlist) {
            totalprice+=products.getPrice();
        }
    }

    public double getTotalprice() {
        return totalprice;
    }

    public ArrayList<ProductModel> getProductlist() {
        return productlist;
    }
}
