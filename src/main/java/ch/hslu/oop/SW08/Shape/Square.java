package ch.hslu.oop.SW08.Shape;

/**
 * The <code>Square</code> class represents a square with a given x and y coordinate and a side length.
 * @author Urs Bollhalder
 * @version 1.0
 * @see Rectangle
 * @see Circle
 * @see Shape
 */
public final class Square extends Shape {
    /**
     * This main method creates a new Square object and tests its functionality.
     * @param args main arguments
     */
    public static void main(String[] args) {
        Square sq = new Square(20, 40, 200);

        System.out.println(sq.getArea());
        System.out.println(sq.getPerimeter());
    }

    /**
     * Constructor for the Square class.
     * @param x x-coordinate of the square
     * @param y y-coordinate of the square
     * @param side length of the side of the square
     */
    public Square (final int x, final int y, final int side) {
        super(x, y);

        // Rectangle just used for area, perimeter calcs and dimension changes. Private to square and 
        // stays at 0,0.
        this.rectangle = new Rectangle(0, 0, side, side);
    }
    
    @Override 
    public int getArea() {
        return this.rectangle.getArea();
    }

    @Override
    public int getPerimeter() {
        return this.rectangle.getPerimeter();
    }

    /**
     * Changes the dimension of the square.
     * @param newSide new side length of the square
     */
    public void changeDimension(int newSide) {
        this.rectangle.changeDimension(newSide, newSide);
    }

    // ----------------------- PRIVATE --------------------------------
    private Rectangle rectangle;
}
