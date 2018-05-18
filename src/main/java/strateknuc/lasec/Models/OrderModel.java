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
    }

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

