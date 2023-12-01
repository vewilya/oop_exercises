package ch.hslu.oop.SW06.Named;

import java.util.UUID;

/**
 * The <code>Product</code> class represents a product with a given name and id.
 * <p>It implements the Named interface and provides methods to get and set the name of the product.
 * @author  Urs Bollhalder
 * @version 1.0
 * @see ch.hslu.oop.SW05.Named.Named
 */
public final class Product implements Named, Categorisable {

    /**
     * Default Constructor
     */
    public Product() {
        this.name = "unknown";
        this.id = this.generateId();
        this.category = new Category();
        this.category.setName("Utilities");
    }

    /**
     * Constructor with name and categoryName parameter .
    */
    public Product(String name, String categoryName) {
        this.name = name;
        this.id = this.generateId();

        this.category = new Category();
        this.category.setName(categoryName);
    }

    /**
     * A method to set the name of the product.
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }

    /**
     * A method to return the name of the product as a String.
     * @return The name of the product.
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * A method to return the id of the product as a String.
     * @return The id of the product.
     */
    public String getId() {
        return this.id;
    }

    @Override
    public void setCategoryName(String categoryName) {
        this.category.setName(categoryName);
    }

    @Override
    public String getCategoryName() {
        return this.category.getName();
    }

    // ------------------------ Private -------------------------
    /**
     * Generates a random id for the product upon instantiation of a Product object.
     */
    private String generateId() {

        // Immutable Universally Unique Identifier
        String id = UUID.randomUUID().toString().substring(0, 13);
        return id;
    }

    private String name;
    private String id;
    private Category category;
}
