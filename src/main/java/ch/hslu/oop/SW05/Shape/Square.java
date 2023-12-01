package ch.hslu.oop.SW05.Shape;

/**
 * The <code>Square</code> class represents a square with a given x and y coordinate and a side length.
 * @author Urs Bollhalder
 * @version 1.0
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
        this.side = side;
    }
    
    @Override 
    public int getArea() {
        int area = (int) Math.pow(this.side, 2);

        return area;
    }

    @Override
    public int getPerimeter() {
        int perimeter = 4 * this.side;

        return perimeter;
    }

    // ----------------------- PRIVATE -------------------------

    private int side;
}
