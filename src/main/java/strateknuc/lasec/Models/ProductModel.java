package strateknuc.lasec.Models;

public class ProductModel {

    private int id;
    private String name;
    private String category;
    private String manufacturer;
    private int quantity;
    private double price;
    private String description;

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


}
