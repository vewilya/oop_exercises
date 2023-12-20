package ch.hslu.oop.SW04.Switchable;

/**
 * The <code>Engine</code>> class implements an engine that can be swithced on
 * and off.
 *
 * @author Urs Bollhalder
 * @version 1.0
 * @see ch.hslu.oop.SW04.Switchable.Car
 * @see ch.hslu.oop.SW04.Switchable.Lights
 * @see ch.hslu.oop.SW04.Switchable.MusicPlayer
 */
public final class Engine implements Switchable {

    /**
     * Default constructor for the Engine class.
     */
    public Engine() {
    }

    /**
     * Constructor that takes in a parameter for the current motor state.
     *
     * @param isEngineSwitchedOn The initial state of the engine.
     */
    public Engine(boolean isEngineSwitchedOn) {
        this.isEngineSwitchedOn = isEngineSwitchedOn;
        this.rpm = 100;
    }

    /**
     * Switches the engine on.
     */
    @Override
    public void switchOn() {
        this.isEngineSwitchedOn = true;
        this.rpm = 100;
        System.out.println("Engine switched on. RPM is:" + this.rpm);
    }

    /**
     * Switches the engine off.
     */
    @Override
    public void switchOff() {
        this.rpm = 0;
        this.isEngineSwitchedOn = false;
        System.out.println("Engine switched off. RPM is:" + this.rpm);
    }

    /**
     * Returns true if the engine is switched on, false otherwise.
     *
     * @return The current state of the engine.
     */
    @Override
    public boolean isSwitchedOn() {
        return this.isEngineSwitchedOn;
    }

    /**
     * Returns true if the engine is switched off, false otherwise.
     *
     * @return The current state of the engine.
     */
    @Override
    public boolean isSwitchedOff() {
        // return !this.isEngineSwitchedOn;
        return !this.isSwitchedOn();
    }

    /**
     * Returns the current RPM of the engine.
     *
     * @return The current RPM of the engine.
     */
    public int getCurrentRpm() {
        return this.rpm;
    }

    /**
     * Our main attribute holding the current state of the motor.
     */
    private boolean isEngineSwitchedOn = false;

    /**
     * Parameter for rotation per minute of the motor engine.
     */
    private int rpm = 0;
}
