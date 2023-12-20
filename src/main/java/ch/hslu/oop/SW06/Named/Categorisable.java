package ch.hslu.oop.SW06.Named;

/**
 * This interface represents a categorisable object.
 */
public interface Categorisable {

    /**
     * Sets the category name.
     * 
     * @param categoryName
     */
    void setCategoryName(String categoryName);

    /**
     * Gets the category name as a String.
     * 
     * @return category name as a String.
     */
    String getCategoryName();
}