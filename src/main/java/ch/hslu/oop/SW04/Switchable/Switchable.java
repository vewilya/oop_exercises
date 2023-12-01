package ch.hslu.oop.SW04.Switchable;

/**
 * The <code>Switchable</code> interface represents a switchable element.
 * <p>It provides methods to switch the element on and off as well as methods to check the current state of the element.
 * @author Urs Bollhalder
 * @version 1.0
 */

public interface Switchable {
    /**
     * A method to switch on the element.
     */
    void switchOn();

    /**
     * A method to switch off the element.
     */
    void switchOff();

    /**
     * Returns the switchedOn state of the element.
     * @return The switchedOn state of the element
     */ 
    boolean isSwitchedOn();

    /**
     * Returns the switchedOff state of the element.
     * @return The switchedOff state of the element
     */
    boolean isSwitchedOff();
}