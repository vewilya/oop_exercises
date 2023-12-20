package ch.hslu.oop.SW06.Named;

/**
 * The <code>Named</code> interface represents a named element.
 * <p>
 * It provides methods to get and set the name of the element.
 * 
 * @author Urs Bolhalder
 * @version 1.0
 */
public interface Named {

    /**
     * Method to retun the name of the element.
     * 
     * @return The name of the element.
     */
    String getName();

    /**
     * Method to set the name of the element.
     * 
     * @param name The name of the element.
     */
    void setName(String name);
}
