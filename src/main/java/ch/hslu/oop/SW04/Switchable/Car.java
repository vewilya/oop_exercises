package ch.hslu.oop.SW04.Switchable;

/**
 * The <code>Car</code> class represents a car object that can be switched on or off.
 * <p>It makes use of the <code>Lights</code> and <code>Engine</code> class.
 * @author Urs Bollhalder
 * @version 1.0
 * @see ch.hslu.oop.SW04.src_Switchable.Engine
 * @see ch.hslu.oop.SW04.src_Switchable.Lights
 * @see ch.hslu.oop.SW04.src_Switchable.MusicPlayer
 */

/**
 * A class representing a car that implements the Switchable interface, as well as making use of the <code>Engine</code> class and the <code>Lights</code> class.
 */
public final class Car implements Switchable {

    /**
     * This main method creates a new Car object and tests its functionality.
     * @param args
     */
    // public static void main(final String[] args) {
    //     Car car = new Car();

    //     System.out.println(car.isSwitchedOn());

    //     System.out.println(car.isCarLightsSwitchedOn());
    //     car.switchOnCarMusicPlayer();
    // }

    /**
     * Constructs a new Car object.
     */
    public Car() {
        this.engine = new Engine(false);
        this.lights = new Lights();
        this.musicPlayer = new MusicPlayer();
    }

    // ------------------------------ Switchable ------------------------------
    /**
     * Switches on the car and its engine.
     */
    @Override
    public void switchOn() {
        this.isCarSwitchedOn = true;
        engine.switchOn();
        lights.switchOn();
    }

    /**
     * Switches off the car and its engine.
     */
    @Override
    public void switchOff() {
        this.isCarSwitchedOn = false;
        engine.switchOff();
        lights.switchOff();
    }

    /**
     * Returns true if the car is switched on, false otherwise.
     *
     * @return true if the car is switched on, false otherwise.
     */
    @Override
    public boolean isSwitchedOn() {
        return this.isCarSwitchedOn;
    }

    /**
     * Returns true if the car is switched off, false otherwise.
     *
     * @return true if the car is switched off, false otherwise.
     */
    @Override
    public boolean isSwitchedOff() {
        return !this.isCarSwitchedOn;
    }

    // ------------------------------ Lights ------------------------------
    /**
     * Switches on the car lights.
     */
    public void switchOnLights() {
        lights.switchOn();
    }

    /**
     * Switches off the car lights.
     */
    public void switchOffLights() {
        lights.switchOff();
    }

    /**
     * Returns true if the car lights are switched on, false otherwise.
     *
     * @return true if the car lights are switched on, false otherwise.
     */
    public boolean isCarLightsSwitchedOn() {
        return lights.isSwitchedOn();
    }

    /**
     * Returns true if the car engine is switched on, false otherwise.
     *
     * @return true if the car engine is switched on, false otherwise.
     */
    public boolean isCarEngineSwitchedOn() {
        return engine.isSwitchedOn();
    }

    // ------------------------------ Engine ------------------------------
    /**
     * Returns the current RPM of the car engine.
     *
     * @return the current RPM of the car engine.
     */
    public int getCarEngineRpm() {
        return engine.getCurrentRpm();
    }

    // ------------------------------ MusicPlayer --------------------------
    /**
     * Switches on the car music player.
     */
    public void switchOnCarMusicPlayer() {
        musicPlayer.switchOn();
    }

    /**
     * Switches off the car music player.
     */
    public void switchOffCarMusicPlayer() {
        musicPlayer.switchOff();
    }

    // ------------------------------ Private ------------------------------
    /**
     * A boolean representing the current state of the car.
     */
    private boolean isCarSwitchedOn = false;

    /**
     * A reference to the engine object of the car.
     */
    private Engine engine;

    /**
     * A reference to the lights object of the car.
     */
    private Lights lights;

    /**
     * A reference to the music player object of the car.
     */
    private MusicPlayer musicPlayer;

}
