package strateknuc.lasec.Models;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ProductOrderModel {

    private int orderId;
    private String date;
    private String customerName;
    private String customerEmail;
    private String ean;
    private int quantity;

    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public ProductOrderModel() {

    }

    public ProductOrderModel(int orderId, Date date, String customerName, String customerEmail, String ean, int quantity) {
        this.orderId = orderId;
        this.date = dateFormat.format(date);
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.ean = ean;
        this.quantity = quantity;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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

    public String getEan() {
        return ean;
    }

    public void setEan(String ean) {
        this.ean = ean;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
