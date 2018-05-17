package strateknuc.lasec.Models;

public class ProductModel {

    //LKB
    private int quantity;
    private String name, ean, category, manufacturer, description;
    private double price;

    //LKB
    public ProductModel(String ean, String name, String category, String manufacturer, int quantity, double price,
                        String description) {
        this.ean = ean;
        this.name = name;
        this.category = category;
        this.manufacturer = manufacturer;
        this.quantity = quantity;
        this.price = price;
        this.description = description;
    }

    // AUTHOR: LKB
    public ProductModel() {

    }

    // AUTHOR(S): ECS
    // Constructor used to get a list of products
    public ProductModel(String name, double price, String ean) {
        this.name = name;
        this.price = price;
        this.ean = ean;
    }

    // Getters & Setters
    public String getEan() {
        return ean;
    }

    public void setEan(String ean) {
        this.ean = ean;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
