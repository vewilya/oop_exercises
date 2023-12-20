package ch.hslu.oop.SW08.Shape;

/**
 * The <code>Rectangle</code> class represents a rectangle with a given x and y
 * coordinate and a width and height.
 * This class extends the Shape class.
 * 
 * @author Urs Bollhalder
 * @version 1.0
 * @see Shape
 * @see Circle
 * @see Square
 */
public class Rectangle extends Shape {

    /**
     * Constructor for the Rectangle class.
     * 
     * @param x      x-coordinate of the rectangle
     * @param y      y-coordinate of the rectangle
     * @param width  width of the rectangle
     * @param height height of the rectangle
     */
    protected Rectangle(final int x, final int y, final int width, final int height) {
        super(x, y);
        this.width = width;
        this.height = height;
    }

    @Override
    public int getPerimeter() {
        return (2 * this.width) + (2 * this.height);
    }

    @Override
    public int getArea() {
        int area = this.width * this.height;
        return area;
    }

    /**
     * Changes the dimension of the rectangle.
     * 
     * @param newWidth  new width of the rectangle
     * @param newHeight new height of the rectangle
     */
    public void changeDimension(int newWidth, int newHeight) {
        this.width = newWidth;
        this.height = newHeight;
    }

    // ------------------------ PRIVATE -----------------------
    private int width;
    private int height;
}
