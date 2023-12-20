package ch.hslu.oop.SW07.Point;

import java.util.Objects;

/**
 * The Point class represents a point in a two-dimensional coordinate system.
 * 
 * @author Urs Bollhalder
 * @version 1.0
 */
public class Point implements Comparable<Point> {

    // ------------------------ Attributes ------------------------ //
    private int x, y;

    // ------------------------ Constructor ------------------------ //
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
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // ------------------------ Setters & Getters ------------------------ //
    /**
     * Returns the x-coordinate of the point.
     *
     * @return the x-coordinate of the point
     */
    public int getX() {
        return this.x;
    }

    /**
     * Returns the y-coordinate of the point.
     *
     * @return the y-coordinate of the point
     */
    public int getY() {
        return this.y;
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
    public int getQuadrant(int x, int y) {
        int quadrant = 0;

        if (x >= 0) {
            if (y >= 0) {
                quadrant = 1;
            } else {
                quadrant = 4;
            }
        } else {
            if (y >= 0) {
                quadrant = 2;
            } else {
                quadrant = 3;
            }
        }

        return quadrant;
    }

    // ------------------------ Equals & Hash ------------------------ //
    @Override
    public final boolean equals(final Object object) {
        if (object == this) {
            return true;
        }

        // Checking for id only, as this is the only immutable attribute.
        return (object instanceof Point p)
                && (p.x == this.x)
                && (p.y == this.y);
    }

    @Override
    public final int hashCode() {
        return Objects.hash(this.x, this.y);
    }

    // ---------------------- CompareTo Method Override ---------------------- //
    @Override
    public int compareTo(Point otherPoint) {
        return Float.compare(this.x, otherPoint.x);
    }

}
