package ch.hslu.oop.SW06.Named;

/**
 * This class represents a store.
 * This class represents a store and implements the Named interface.
 */
public class Store implements Named {

    public Store(String name) {
        this.storeName = name;
    }

    public Store() {
        this.storeName = "unknown store";
    }

    @Override
    public String getName() {
       return this.storeName;
    }

    @Override
    public void setName(String storeName) {
        this.storeName = storeName;
        
    }
    
    // ---------------- Private ---------------- 

    private String storeName;

}
