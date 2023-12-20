package ch.hslu.oop.SW05.Switchable;

/**
 * The <code>Lights</code> class represents a switchable light element.
 * <p>
 * It implements the Switchable interface and provides methods to switch the
 * lights on and off as well as methods to check the current state of the
 * lights.
 * 
 * @author Urs Bollhalder
 * @version 1.0
 * @see ch.hslu.oop.SW05.Switchable.Engine
 * @see ch.hslu.oop.SW05.Switchable.Car
 */
public final class Lights implements Switchable {

    /**
     * Constructs a new Lights object.
     */
    public Lights() {
    }

    /**
     * Switches the lights on.
     */
    @Override
    public void switchOn() {
        this.areLightsSwitchedOn = true;
    }

    /**
     * Switches the lights off.
     */
    @Override
    public void switchOff() {
        this.areLightsSwitchedOn = false;
    }

    /**
     * Returns true if the lights are switched on, false otherwise.
     * 
     * @return true if the lights are switched on, false otherwise.
     */
    @Override
    public boolean isSwitchedOn() {
        return this.areLightsSwitchedOn;
    }

    /**
     * Returns true if the lights are switched off, false otherwise.
     * 
     * @return true if the lights are switched off, false otherwise.
     */
    @Override
    public boolean isSwitchedOff() {
        return !this.areLightsSwitchedOn;
    }

    private boolean areLightsSwitchedOn = false;
}
