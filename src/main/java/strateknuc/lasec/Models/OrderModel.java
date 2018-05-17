package strateknuc.lasec.Models;

import java.util.ArrayList;

// AP,SS, LKB
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
