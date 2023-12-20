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
    }

    private final void handleViewEvent(PropertyChangeEvent event) {
        if (event.getPropertyName() == "EngineState" && event.getNewValue() == State.ON) {
            LOG.info("Control: Receiving event {}", event.getNewValue());
            this.engine.switchOn();
        } else if (event.getPropertyName() == "EngineState" && event.getNewValue() == State.OFF) {
            this.engine.switchOff();
        } else if (event.getPropertyName() == "increaseRPM") {
            this.engine.increaseRPM();
        } else if (event.getPropertyName() == "DecreaseRPM") {
            this.engine.decreaseRPM();
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
