package ch.hslu.oop.SW13.Car;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class Engine implements Switchable {

    // Attributes
    private int rpm = 0;
    private State engineState = State.OFF;
    private final List<PropertyChangeListener> changeListeners = new ArrayList<>();
    private static final Logger LOG = LoggerFactory.getLogger(Engine.class);

    public Engine() {
    }

    public Engine(boolean isEngineSwitchedOn) {
        this.engineState = isEngineSwitchedOn ? State.ON : State.OFF;
        this.rpm = 100;
    }

    @Override
    public void switchOn() {
        if (isSwitchedOff()) {

            // Muss hier stehen und nicht nach der Versendung der Events!
            this.engineState = State.ON;
            this.rpm = 100;

            // Fire Event
            this.firePropertyChangeEvent(new PropertyChangeEvent(this, "Engine State", State.OFF, State.ON));

            LOG.info("Engine switched on. RPM is: {}", this.rpm);
        }
    }

    @Override
    public void switchOff() {
        if (isSwitchedOn()) {

            this.engineState = State.OFF;
            this.rpm = 0;

            // Fire Event
            this.firePropertyChangeEvent(new PropertyChangeEvent(this, "EngineState", State.ON, State.OFF));

            LOG.info("Engine switched off. RPM is: {}", this.rpm);
        }
    }

    public final void increaseRPM() {
        this.rpm += 100;
        LOG.info("RPM increased to: {}", this.rpm);
    }

    public final void decreaseRPM() {
        this.rpm -= 100;
        LOG.info("RPM decreased to: {}", this.rpm);
    }

    @Override
    public boolean isSwitchedOn() {
        return this.engineState.equals(State.ON);
    }

    @Override
    public boolean isSwitchedOff() {
        return !this.isSwitchedOn();
    }

    public int getCurrentRpm() {
        return this.rpm;
    }

    // PropertyChange Listeners
    public void addPropertyChangeListener(final PropertyChangeListener listener) {
        try {
            this.changeListeners.add(listener);
        } catch (NullPointerException npe) {
            LOG.error("There is no listener object being handed over", npe.getMessage());
        }
    }

    public void removePropertyChangeListener(final PropertyChangeListener listener) {
        try {
            this.changeListeners.remove(listener);
        } catch (NullPointerException npe) {
            LOG.error("There is no listener object being handed over", npe.getMessage());
        }
    }

    private void firePropertyChangeEvent(final PropertyChangeEvent event) {

        for (final PropertyChangeListener listener : this.changeListeners) {
            listener.propertyChange(event);
        }
    }
}
