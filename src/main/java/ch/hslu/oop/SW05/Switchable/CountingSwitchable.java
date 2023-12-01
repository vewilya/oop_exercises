package ch.hslu.oop.SW05.Switchable;

/**
 * The <code>Switchable</code> interface represents a switchable element.
 * <p>It provides methods to switch the element on and off as well as methods to check the current state of the element.
 * @author Urs Bollhalder
 * @version 1.0
 * @see ch.hslu.oop.SW05.src_Switchable.Switchable
 * @see ch.hslu.oop.SW05.src_Switchable.Playable
 * @see ch.hslu.oop.SW05.src_Switchable.Car  
 * @see ch.hslu.oop.SW05.src_Switchable.Lights
 * @see ch.hslu.oop.SW05.src_Switchable.MusicPlayer
 * @see ch.hslu.oop.SW05.src_Switchable.Engine
 */

/**
 * The <code>CountingSwitchable</code> interface represents an extended switchable element with 
 * an added method to get the switch count.
 */
public interface CountingSwitchable extends Switchable {

    /**
     * Returns the number of times the element has been switched on or off.
     * @return The number of times the element has been switched on or off.
     */
    long getSwitchCount();
}