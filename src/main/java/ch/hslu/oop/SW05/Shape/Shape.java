package ch.hslu.oop.SW05.Shape;

/**
 * The <code>Shape</code> class represents a shape with a given x and y
 * coordinate.
 * The <code>Shape</code> class acts as the base class for all shapes.
 */
public abstract class Shape {

    /**
     * Constructor taking in a given x and y coordinate.
     * 
     * @param x x-coordinate
     * @param y y-coordinate
     */
    protected Shape(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Moves the shape to a new x and y coordinate.
     * 
     * @param newX new x-coordinate
     * @param newY new y-coordinate
     */
    public final void move(final int newX, final int newY) {
        this.x = newX;
        this.y = newY;
    }

    /**
     * Returns the perimeter of the shape as an integer.
     * 
     * @return Perimeter of the shape as an integer
     */
    public abstract int getPerimeter();

    /**
     * Returns the area of the shape as an integer.
     * 
     * @return Area of the shape as an integer
     */
    public abstract int getArea();

    // ---------------------- PRIVATE -------------------------
    private int x;
    private int y;
}
