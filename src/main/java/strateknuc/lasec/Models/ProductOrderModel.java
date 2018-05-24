package strateknuc.lasec.Models;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author LKB
 */
public class ProductOrderModel {

    private int orderId, quantity;
    private String ean, customerName, customerEmail, date;

    // Formats a date to "yyyy-MM-dd HH:mm:ss" example: "2018-05-18 13:57:25"
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * Empty constructor for Spring
     */
    public ProductOrderModel() {

    }

    /**
     * Constructor in order to create a ProductOrderModel
     * @param orderId The id of the order
     * @param date The date and timestamp of when the is is placed
     * @param customerName The name of the customer who makes the order
     * @param customerEmail The email of the customer who makes the order
     * @param ean The ean number of the product that is ordered
     * @param quantity The quantity of the product that is ordered
     */
    public ProductOrderModel(int orderId, Date date, String customerName, String customerEmail, String ean, int quantity) {
        this.orderId = orderId;
        this.date = dateFormat.format(date);
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.ean = ean;
        this.quantity = quantity;
    }

    /**
     * Gets the orderId
     * @return The orderId
     */
    public int getOrderId() {
        return orderId;
    }

    /**
     * Sets the orderId
     * @param orderId The id of an order
     */
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    /**
     * Gets the date and timestamp
     * @return the date and timestamp
     */
    public String getDate() {
        return date;
    }

    /**
     * Sets the date
     * @param date The date and timestamp
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * Gets the customers name
     * @return The customers name
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * Sets the customers name
     * @param customerName The name of a customer
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    /**
     * Gets the email of a customer
     * @return The email of a customer
     */
    public String getCustomerEmail() {
        return customerEmail;
    }

    /**
     * Sets the email for a customer
     * @param customerEmail A customers email
     */
    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    /**
     * Gets the ean number
     * @return The ean number
     */
    public String getEan() {
        return ean;
    }

    /**
     * Sets the ean number
     * @param ean An ean number
     */
    public void setEan(String ean) {
        this.ean = ean;
    }

    /**
     * Gets the quantity
     * @return The quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the quantity
     * @param quantity The quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
