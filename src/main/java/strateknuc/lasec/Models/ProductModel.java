package strateknuc.lasec.Models;

public class ProductModel {

    private int id, quantity;
    private String name, category, manufacturer, description;
    private double price;

    public ProductModel(int id, String name, String category, String manufacturer, int quantity, double price,
                        String description) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.manufacturer = manufacturer;
        this.quantity = quantity;
        this.price = price;
        this.description = description;
    }

    public ProductModel() {

    }

    // Getters & Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
