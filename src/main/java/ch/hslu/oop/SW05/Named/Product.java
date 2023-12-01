package ch.hslu.oop.SW05.Named;

import java.util.UUID;

/**
 * The <code>Product</code> class represents a product with a given name and id.
 * <p>It implements the Named interface and provides methods to get and set the name of the product.
 * @author  Urs Bollhalder
 * @version 1.0
 * @see ch.hslu.oop.SW05.Named.Named
 */
public final class Product implements Named {

    // public static void main(String[] args) {
    //     Product p = new Product();
    //     System.out.println(p.getId());
    //     System.out.println(p.getName());

    //     p.setName("Delay Lama");
    //     System.out.println(p.getName());
    // }

    /**
     * Default Constructor
     */
    public Product() {
        this.name = "unknown";
        
        this.id = this.generateId();
    }

    /**
     * A method to set the name of the product.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * A method to return the name of the product as a String.
     * @return The name of the product.
     */
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

}
