package strateknuc.lasec.Models;

/**
 * @author LKB, ECS
 */
public class ProductModel {

    // AUTHOR(S): LKB

    private int quantity;
    private String name, ean, category, manufacturer, description;
    private double price;

    // AUTHOR(S): LKB

    /**
     * Constructor in order to create a ProductModel
     * @param ean The ean number of the product
     * @param name The name of the product
     * @param category The category of which the product belongs to
     * @param manufacturer The manufacturer of the product
     * @param quantity The quantity of the product
     * @param price The price of the product
     * @param description The description of the product
     */
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

    // AUTHOR(S): LKB
    /**
     * Empty constructor for Spring
     */
    public ProductModel() {

    }

    // AUTHOR(S): ECS
    /**
     * Constructor used to get a list of products
     * @param name The name of the product
     * @param price The price of the product
     * @param ean The ean number of the product
     */
    public ProductModel(String name, double price, String ean) {
        this.name = name;
        this.price = price;
        this.ean = ean;
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
     * Gets the name of the product
     * @return The name of the product
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the product
     * @param name The name to set it to
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the category of the product
     * @return The category of the product
     */
    public String getCategory() {
        return category;
    }

    /**
     * Sets the category of the product
     * @param category The category to set it to
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * Gets the manufacturer of a product
     * @return The manufacturer
     */
    public String getManufacturer() {
        return manufacturer;
    }

    /**
     * Sets the manufacturer of a product
     * @param manufacturer The manufacturer to set it to
     */
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    /**
     * Gets the quantity of a product
     * @return The quantity of a product
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the quantity of a product
     * @param quantity The quantity to set it to
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Gets the price of a product
     * @return The price of a product
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the price of a product
     * @param price The price to set it to
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Gets the description of a product
     * @return The description of a product
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of a product
     * @param description The description to set it to
     */
    public void setDescription(String description) {
        this.description = description;
    }
}
