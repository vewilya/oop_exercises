package ch.hslu.oop.SW06.Line;

import java.util.Arrays;

/**
 * Class representing a line with a start and end point.
 * 
 * @author Urs Bollhalder
 * @version 1.0
 * @see ch.hslu.oop.SW04.Line.Point
 */
public final class Line {

    /**
     * Constructor taking in 4 integer values as parameters to define x and y
     * coordinates of start and end point.
     *
     * @param x1 x-coordinate of the start point
     * @param y1 y-coordinate of the start point
     * @param x2 x-coordinate of the end point
     * @param y2 y-coordinate of the end point
     */
    public Line(int x1, int y1, int x2, int y2) {
        this.startPoint.setCoordinates(x1, y1);
        this.endPoint.setCoordinates(x2, y2);
    }

    /**
     * Returns the start point of the line as a string.
     *
     * @return Start point of the line as a string
     */
    public String getStartPoint() {
        return Arrays.toString(startPoint.getCoordinates());
    }

    /**
     * Returns the end point of the line as a string.
     *
     * @return End point of the line as a string
     */
    public String getEndPoint() {
        return Arrays.toString(endPoint.getCoordinates());
    }

    /**
     * Returns the end point of the line as an object.
     *
     * @return End point line object
     */
    public Point getStartPointObject() {
        return startPoint;
    }

    /**
     * Returns the end point of the line as an object.
     *
     * @return line end point object
     */
    public Point getEndPointObject() {
        return endPoint;
    }

    /**
     * Sets the start point of the line.
     *
     * @param x x-coordinate of the start point
     * @param y y-coordinate of the start point
     */
    public void setStartPoint(int x, int y) {
        this.startPoint.setCoordinates(x, y);
    }

    /**
     * Sets the end point of the line.
     *
     * @param x x-coordinate of the end point
     * @param y y-coordinate of the end point
     */
    public void setEndPoint(int x, int y) {
        this.endPoint.setCoordinates(x, y);
    }

    /**
     * Returns the coordinates of the line's start and end points as a string.
     *
     * @return Coordinates of the line's start and end points as a string
     */
    public String getCoordinates() {
        int[] out = { startPoint.getX(), startPoint.getY(), endPoint.getX(), endPoint.getY() };
        return Arrays.toString(out);
    }

    // --------------------------------------

    private Point startPoint = new Point();
    private Point endPoint = new Point();
}
