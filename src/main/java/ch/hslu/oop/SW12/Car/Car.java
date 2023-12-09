package ch.hslu.oop.SW12.Car;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class Car implements Switchable {

    // ------------------------------ Attributes ---------------------------- //

    private State carState = State.OFF;
    private Engine engine;
    private Lights lights;
    
    private static final Logger LOG = LoggerFactory.getLogger(Car.class);

    public Car() {
        this.engine = new Engine(false);
        this.lights = new Lights();
        this.carState = State.OFF;

        // this.engine.addEngineChangeListener(engineEvent -> this.handleEngineEvent );
        // this.lights.addPropertyChangeListener(lightsEvent -> this.handleLightsEvent);

        this.engine.addPropertyChangeListener(this::handleEngineEvent);
        this.lights.addPropertyChangeListener(this::handleLightsEvent);
    }

    @Override
    public void switchOn() {
        if (this.carState == State.OFF) {
            
            engine.switchOn();
            lights.switchOn();

            this.carState = State.ON;
        }

        LOG.info("Car state is {}, enigne state is {} and lights state is {}", this.carState, this.engine.isSwitchedOn(), this.lights.isSwitchedOn());
    }

   
    @Override
    public void switchOff() {
        if (this.carState == State.ON) {
            
            this.carState = State.OFF;

            engine.switchOff();
            lights.switchOff();

            
        }
            
        LOG.info("Car state is {}, enigne state is {} and lights state is {}", this.carState, this.engine.isSwitchedOn(), this.lights.isSwitchedOn());
    }


    @Override
    public boolean isSwitchedOn() {
        return this.carState.equals(State.ON);
    }


    @Override
    public boolean isSwitchedOff() {
        return !this.isSwitchedOn();
    }

    // ------------------------------ Engine ------------------------------
    
    public int getCarEngineRpm() {
        return engine.getCurrentRpm();
    }


    // --------------- toString() ---------------- //
    @Override
    public String toString() {
        return ("Car Object state: " + this.carState);
    }

    private final void handleEngineEvent(PropertyChangeEvent event) {
        if (this.carState == State.OFF)
            this.engine.switchOn();
        else 
            this.engine.switchOff();
    } 

    private final void handleLightsEvent(PropertyChangeEvent event) {
        if (this.carState == State.OFF)
            this.lights.switchOn();
        else 
            this.lights.switchOff();
    }
}
