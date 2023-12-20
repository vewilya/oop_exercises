package ch.hslu.oop.SW13.Car;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

public final class Lights implements Switchable {

    // ------------------ Attributes -------------------- //
    private State lightsState = State.OFF;

    private final List<PropertyChangeListener> changeListeners = new ArrayList<>();

    public Lights() {
    }

    @Override
    public void switchOn() {
        if (this.lightsState == State.OFF) {
            this.lightsState = State.ON;
            this.firePropertyChangeEvent(new PropertyChangeEvent(this, "lights state", State.OFF, State.ON));
        }
    }

    @Override
    public void switchOff() {
        if (this.lightsState == State.ON) {
            this.lightsState = State.OFF;
            this.firePropertyChangeEvent(new PropertyChangeEvent(this, "lights state", State.ON, State.OFF));
        }
    }

    @Override
    public boolean isSwitchedOn() {
        return this.lightsState.equals(State.ON);
    }

    @Override
    public boolean isSwitchedOff() {
        return !isSwitchedOn();
    }

    // Event Listener
    public void addPropertyChangeListener(final PropertyChangeListener listener) {
        if (!listener.equals(null))
            this.changeListeners.add(listener);
    }

    public void removePropertyChangeListener(final PropertyChangeListener listener) {
        if (!listener.equals(null))
            this.changeListeners.remove(listener);
    }

    private void firePropertyChangeEvent(final PropertyChangeEvent pcEvent) {
        for (final PropertyChangeListener listener : this.changeListeners) {
            listener.propertyChange(pcEvent);
        }
    }
}
