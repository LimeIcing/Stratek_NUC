package strateknuc.lasec.Models;

/**
 * @author ECS
 */
public class CategoryModel {

    private String name;

    /**
     * Empty constructor for Spring
     */
    public CategoryModel() {

    }

    /**
     * Constructor to create a category
     * @param name The name of the category
     */
    public CategoryModel(String name) {
        this.name = name;
    }

    /**
     * Gets the name of the category
     * @return The name of the category
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the category
     * @param name The name to set the category to
     */
    public void setName(String name) {
        this.name = name;
    }
}
