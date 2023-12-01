package ch.hslu.oop.SW08.Shape;
/**
 * The <code>Circle</code> class represents a circle with a given x and y coordinate and a radius.
 */
public final class Circle extends Shape{

    /**
     * This main method creates a new Circle object and tests its functionality.
     * @param args main arguments
     */
    public static void main(String[] args) {
        Circle c = new Circle(30, 60, 12);

        System.out.println(c.getArea());
        System.out.println(c.getPerimeter());
    }

    /**
     * Default constructor for the Circle class.
     *
     * @param x The x coordinate of the circle.
     * @param y The y coordinate of the circle.
     * @param radius The radius of the circle.
     */
    public Circle(final int x, final int y, final int radius) {
        super(x, y);
        this.radius = radius;
    }
    
    @Override
    public int getPerimeter() {
        int perimeter = (int) Math.round(2 * Math.PI * this.radius); 
        return perimeter;
    }

    @Override
    public int getArea() {
        int area = (int) (Math.PI * Math.pow(this.radius, 2));
        return area;
    }

    /**
     * Returns the diameter of the circle.
     * @return diameter of the circle
     */
    public int getDiameter() {
        return this.radius * 2;
    }

    public void changeDimension(int newRadius) {
        this.radius = newRadius;
    }

    // ---------------- PRIVATE ---------------
    private int radius;
}
