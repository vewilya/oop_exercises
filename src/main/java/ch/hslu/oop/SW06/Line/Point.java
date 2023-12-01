package ch.hslu.oop.SW06.Line;

/**
 * The Point class represents a point in a two-dimensional coordinate system.
 * @author Urs Bollhalder
 * @version 1.0
 * @see ch.hslu.oop.SW04.Line.Line
 */
public class Point {

    public static void main(String[] args) {
        Point p = new Point(20, 10);
        System.out.println("x: "+p.getX());
        System.out.println("y: "+p.getY());
        
        p.moveRelativePolar(3/4*Math.PI, 100);
        System.out.println("x: "+p.getX());
        System.out.println("y: "+p.getY());
    }


    /**
     * Constructs a point with initial coordinates (0, 0).
     */
    public Point() {
        this.x = 0;
        this.y = 0;
    }

    /**
     * Constructs a point with the given coordinates.
     *
     * @param x the x-coordinate of the point
     * @param y the y-coordinate of the point
     */
    public Point(int x, int y) 
    {
        this.x = x;
        this.y = y;
    }

    /**
     * Copy constructor
     * 
     * @author Urs Bollhalder
     * @version 1.0
     */
    public Point(Point point) {
        // this.x = point.getX();
        // this.y = point.getY();

        // Bessere Implementierung
        this(point.x, point.y);
    }

    /**
     * Returns the x-coordinate of the point.
     *
     * @return the x-coordinate of the point
     */
    public int getX() 
    {
        return x;
    }

    /**
     * Returns the y-coordinate of the point.
     *
     * @return the y-coordinate of the point
     */
    public int getY(){
        return y;
    }

    /**
     * Sets the x-coordinate of the point.
     *
     * @param x the new x-coordinate of the point
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Sets the y-coordinate of the point.
     *
     * @param y the new y-coordinate of the point
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Moves the x and y coordinates by 2 relative int values deltaX and deltaY.
     * @author Urs Bollhalder
     * @version 1.0
     * @param deltaX The delta value by which the x-coordinate is moved. 
     * @param deltaY The delta value by which the y-coordinate is moved.
     */
    public void moveRelativeCartesian(int deltaX, int deltaY) {
        this.x += deltaX;
        this.y += deltaY;
    }

    /**
     * Moves the x and y coordinates with a point, containing a deltaX and deltaY value.
     * @param point Represents a vector
     */
    public void moveRelativeCartesian(Point point) {
        // this.x += point.getX();
        // this.y += point.getY();
        
        //Better!
        this.moveRelativeCartesian(point.getX(), point.getY());
    }

    /**
     * Move Point relative with polar coordinates angle and vector magnitude
     * @param angle Angle of the vector 
     * @param magnitude Magnitude of the vector
     */
    public void moveRelativePolar(double angle, int magnitude) {
        int deltaY = Math.toIntExact(Math.round(magnitude / Math.sin(Math.toRadians(angle))));
        int deltaX = Math.toIntExact(Math.round(magnitude / Math.cos(Math.toRadians(angle))));

        this.moveRelativeCartesian(deltaX, deltaY);
    }

    /**
     * Sets the coordinates of the point.
     *
     * @param x the new x-coordinate of the point
     * @param y the new y-coordinate of the point
     */
    public void setCoordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Returns the coordinates of the point as an array.
     *
     * @return the coordinates of the point as an array
     */
    public int[] getCoordinates() {
        int[] out = { this.x, this.y };
        return out;
    }

    /**
     * Returns the quadrant of the point in the coordinate system.
     *
     * @param x the x-coordinate of the point
     * @param y the y-coordinate of the point
     * @return the quadrant of the point in the coordinate system
     */
    public int getQuadrant(int x, int y)
    {   
        int quadrant = 0;

        if (x >= 0) {
            if (y >= 0) 
            {
                quadrant = 1;
            } 
            else 
            {
                quadrant = 4;
            }
        }
        else 
        {
            if (y >= 0) 
            {
                quadrant = 2;
            } 
            else 
            {
                quadrant = 3;
            } 
        }

        return quadrant;
    }

    // --------------------------------------
    private int x, y;
}
