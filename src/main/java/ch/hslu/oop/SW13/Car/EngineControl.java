package ch.hslu.oop.SW13.Car;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class EngineControl {

    private final Engine engine;
    private final EngineView engineView;

    private static final Logger LOG = LoggerFactory.getLogger(EngineControl.class);

    /**
     * Constructor
     */
    public EngineControl() {
        this.engine = new Engine();
        this.engineView = new EngineView(this.engine);

        this.engineView.setVisible(true);
        this.engineView.addPropertyChangeListener(this::handleViewEvent);
        this.engine.addPropertyChangeListener(this::handleEngineEvent);
    }

    private final void handleViewEvent(PropertyChangeEvent event) {
        if (event.getPropertyName() == "EngineState" && event.getNewValue() == State.ON) {
            System.out.println("Engine is on!");
            this.engine.switchOn();
        } else if (event.getPropertyName() == "EngineState" && event.getNewValue() == State.OFF) {
            System.out.println("Engine is off!");
            this.engine.switchOff();
        } else if (event.getPropertyName() == "increaseRPM") {
            System.out.println("Increase RPM!");
            this.engine.increaseRPM();
        } else if (event.getPropertyName() == "DecreaseRPM") {
            System.out.println("Decrease RPM!");
            this.engine.decreaseRPM();
        }
    }

    // TODO Implement Engine listener on EngineView
    private final void handleEngineEvent(PropertyChangeEvent event) {
        if (event.getPropertyName() == "EngineState" && event.getNewValue() == State.ON) {
            // this.engineView.updateUI();
        }
    }

    /**
     * main-Methode.
     *
     * @param args nicht verwendet.
     */
    @SuppressWarnings("unused")
    public static void main(final String[] args) {
        LOG.info("Applikation startet...");
        // new EngineView();
        new EngineControl();
    }
}
