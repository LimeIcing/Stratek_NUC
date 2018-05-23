package strateknuc.lasec.Models;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

// AUTHOR(S): LKB
public class ProductOrderModel {

    private int orderId, quantity;
    private String ean, customerName, customerEmail, date;

    // Formats a date to "yyyy-MM-dd HH:mm:ss" example: "2018-05-18 13:57:25"
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    // Empty constructor
    public ProductOrderModel() {

    }

    // Constructor
    public ProductOrderModel(int orderId, Date date, String customerName, String customerEmail, String ean, int quantity) {
        this.orderId = orderId;
        this.date = dateFormat.format(date);
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.ean = ean;
        this.quantity = quantity;
    }

    // Getters & Setters for Spring.
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
