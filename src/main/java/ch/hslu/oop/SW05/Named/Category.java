package ch.hslu.oop.SW05.Named;

public final class Category implements Named {

    public Category() {
        this.categoryName = "unknown";
    }

    public Category(final String name) {
        this.categoryName = name;
    }

    @Override
    public String getName() {
        return this.categoryName;
    }

    @Override
    public void setName(final String name) {
        this.categoryName = name;
    }

    // ---------------------- Private ----------------------

    String categoryName;

}
