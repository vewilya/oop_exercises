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
        // Empty default constructor
    }

    public Engine(boolean isEngineSwitchedOn) {
        this.engineState = isEngineSwitchedOn ? State.ON : State.OFF;
        this.rpm = 100;
    }

    @Override
    public void switchOn() {
        if (this.engineState == State.OFF) {

            // Muss hier stehen und nicht nach der Versendung der Events!
            this.engineState = State.ON;
            this.rpm = 100;

            // Fire Event
            this.firePropertyChangeEvent(new PropertyChangeEvent(this, "EngineState", State.OFF, State.ON));

            LOG.info("Engine switched on. RPM is: {}", this.rpm);
        }
    }

    @Override
    public void switchOff() {
        if (this.engineState == State.ON) {

            this.engineState = State.OFF;
            this.rpm = 0;

            // Fire Event
            this.firePropertyChangeEvent(new PropertyChangeEvent(this, "EngineState", State.ON, State.OFF));

            LOG.info("Engine switched off. RPM is: {}", this.rpm);
        }
    }

    public final void increaseRPM() {
        final int oldRPM = this.rpm;
        this.rpm += 100;
        LOG.info("RPM increased to: {}", this.rpm);
        LOG.info("Old RPM is: {}", oldRPM);
        this.firePropertyChangeEvent(new PropertyChangeEvent(this, "rpmIncrease", oldRPM, this.rpm));
    }

    public final void decreaseRPM() {
        final int oldRPM = this.rpm;
        this.rpm -= 100;
        LOG.info("RPM decreased to: {}", this.rpm);
        LOG.info("Old RPM is: {}", oldRPM);
        this.firePropertyChangeEvent(new PropertyChangeEvent(this, "rpmDecrease", oldRPM, this.rpm));

        if (this.rpm == 0) {
            this.switchOff();
        }
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
        if (listener != null)
            this.changeListeners.add(listener);

    }

    public void removePropertyChangeListener(final PropertyChangeListener listener) {
        if (listener != null)
            this.changeListeners.remove(listener);
    }

    private void firePropertyChangeEvent(final PropertyChangeEvent event) {

        for (final PropertyChangeListener listener : this.changeListeners) {
            listener.propertyChange(event);
        }
    }
}
