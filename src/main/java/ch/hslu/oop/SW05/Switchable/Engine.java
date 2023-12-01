package ch.hslu.oop.SW05.Switchable;

/**
 * The <code>Engine</code>> class implements an engine that can be swithced on and off.
 * @author Urs Bollhalder
 * @version 1.0
 * @see ch.hslu.oop.SW05.Switchable.Car
 * @see ch.hslu.oop.SW05.Switchable.Lights
 * @see ch.hslu.oop.SW05.Switchable.MusicPlayer
 */
public final class Engine implements CountingSwitchable {

    /**
     * This main method creates a new Engine object and tests its functionality.
     * @param args
     */
    // public static void main(String[] args) {
    //     Engine engine = new Engine();
    //     System.out.println(engine.isSwitchedOn());
    //     engine.switchOn();
    //     System.out.println(engine.isSwitchedOn());
    //     engine.switchOff();

    //     for (int i = 0; i < 100; i++) {
    //         engine.switchOff();
    //         engine.switchOn(); 
    //     }
    //     System.out.println(engine.getSwitchCount());
    // }
    /**
     * Default constructor for the Engine class.
     */
    public Engine() {}

    /**
     * Constructor that takes in a parameter for the current motor state.
     * @param isEngineSwitchedOn The initial state of the engine.
     */
    public Engine(boolean isEngineSwitchedOn)
    {
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
        this.switchCount++;
        System.out.println("Engine switched on. RPM is:" + this.rpm);
    }

    /**
     * Switches the engine off.
     */
    @Override
    public void switchOff() {
        this.rpm = 0;
        this.isEngineSwitchedOn = false;
        this.switchCount++;
        System.out.println("Engine switched off. RPM is:" + this.rpm);
    }

    /**
     * Returns true if the engine is switched on, false otherwise.
     * @return The current state of the engine.
     */
    @Override
    public boolean isSwitchedOn() {
        return this.isEngineSwitchedOn;
    }

    /**
     * Returns true if the engine is switched off, false otherwise.
     * @return The current state of the engine.
     */
    @Override
    public boolean isSwitchedOff() {
        // return !this.isEngineSwitchedOn;
        return !this.isSwitchedOn();
    }

    @Override 
    public long getSwitchCount() {
        return this.switchCount;
    }

    /**
     * Returns the current RPM of the engine.
     * @return The current RPM of the engine.
     */
    public int getCurrentRpm() {
        return this.rpm;
    }

    // ---------------------------- PRIVATE --------------------------------
    /**
     * Our main attribute holding the current state of the motor.
     */
    private boolean isEngineSwitchedOn = false;

    /**
     * Parameter for rotation per minute of the motor engine.
     */
    private int rpm = 0;

    /**
     * Counter for the number of times the engine has been switched on or off.
     */
    private long switchCount = 0;
}
