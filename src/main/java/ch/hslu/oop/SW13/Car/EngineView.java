package ch.hslu.oop.SW13.Car;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.border.Border;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

@SuppressWarnings("serial")
public class EngineView extends JFrame implements ActionListener {

    private static final Logger LOG = LoggerFactory.getLogger(EngineView.class);
    private final List<PropertyChangeListener> viewListeners = new ArrayList<>();

    // Engine
    private final Engine engine;

    private final JLabel labelState = new JLabel("Engine is OFF");
    private final JButton buttonOn = new JButton("On");
    private final JButton buttonOff = new JButton("Off");

    private final JButton increaseRPM = new JButton("Increase RPM");
    private final JLabel labelRPM = new JLabel("RPM: 0");
    private final JButton decreaseRPM = new JButton("Decrease RPM");
    private final ImageIcon icon;

    private int counter = 0;

    public enum ViewState {
        ON, OFF, INCREASING, DECREASING
    }

    private ViewState viewState = ViewState.OFF;

    /**
     * Konstruktor.
     */
    public EngineView(final Engine engine) {
        super("EngineView");

        this.engine = engine;
        this.engine.addPropertyChangeListener(this::handleEngineEvent);

        /**
         * UI Setup
         */
        this.buttonOn.addActionListener(this);
        this.buttonOff.addActionListener(this);
        this.increaseRPM.addActionListener(this);
        this.decreaseRPM.addActionListener(this);

        this.labelRPM.setHorizontalAlignment(JLabel.CENTER);

        this.labelState.setHorizontalAlignment(JLabel.CENTER);
        this.labelState.setOpaque(true);
        this.labelState.setBackground(Color.GRAY);

        this.setLayout(new GridLayout(6, 5));

        this.add(buttonOn);
        this.add(labelState);
        this.add(buttonOff);
        this.buttonOff.setEnabled(false);
        this.add(increaseRPM);
        this.add(labelRPM);
        this.add(decreaseRPM);
        this.decreaseRPM.setEnabled(false);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        this.setSize(500, 500);

        this.setVisible(true);

        icon = new ImageIcon("src/main/resources/error.png");
        LOG.info("GUI-Frame aktiviert und sichtbar.");
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed(final ActionEvent event) {
        if (event.getSource() == buttonOn) {
            LOG.info("ActionEvent von ON-Button empfangen.");

            // Fire Event to Controller -> Engine
            this.firePropertyChangeEvent(new PropertyChangeEvent(this, "EngineState", State.OFF, State.ON));

            // Check for Engine Event that set the correct ViewState
            if (viewState == ViewState.ON) {
                this.labelState.setText("Engine is ON.");
                this.labelState.setBackground(Color.GREEN);

                this.buttonOff.setEnabled(true);
                this.buttonOn.setEnabled(false);

                updateRPMLabel();
                runErrorCycle();

                LOG.info("View State correct... Engine is ON.");
            }
        }

        if (event.getSource() == buttonOff) {
            LOG.info("ActionEvent von OFF-Button empfangen.");

            // Fire Event to Controller -> Engine
            this.firePropertyChangeEvent(new PropertyChangeEvent(this, "EngineState", State.ON, State.OFF));

            // Check for Engine Event that set the correct ViewState
            if (viewState == ViewState.OFF) {
                labelState.setText("Engine is OFF");
                labelState.setBackground(Color.GRAY);
                this.buttonOff.setEnabled(false);
                this.buttonOn.setEnabled(true);
                this.decreaseRPM.setEnabled(false);

                updateRPMLabel();
                LOG.info("View State correct... Engine is OFF.");
            }
        }

        if (event.getSource() == increaseRPM) {
            LOG.info("Increase RPM-Button pressed.");

            if (this.viewState == ViewState.OFF) {

                this.firePropertyChangeEvent(new PropertyChangeEvent(this, "EngineState", State.OFF, State.ON));

                if (this.viewState == ViewState.ON) {
                    this.labelState.setText("Engine is ON");
                    this.labelState.setBackground(Color.GREEN);
                    this.buttonOn.setEnabled(false);
                    this.decreaseRPM.setEnabled(true);
                    this.buttonOff.setEnabled(true);
                }

            } else {
                this.firePropertyChangeEvent(new PropertyChangeEvent(this, "increaseRPM",
                        this.labelRPM.getText(), Integer.valueOf(this.engine.getCurrentRpm() + 100)));

                if (this.viewState == ViewState.INCREASING) {
                    this.decreaseRPM.setEnabled(true);
                }

                if (this.engine.getCurrentRpm() > 2000) {
                    rpmError();
                }
            }

            updateRPMLabel();
        }

        if (event.getSource() == decreaseRPM) {
            LOG.info("Decrease RPM-Button pressed.");

            if (this.viewState == ViewState.ON || this.viewState == ViewState.INCREASING
                    || this.viewState == ViewState.DECREASING) {
                this.firePropertyChangeEvent(new PropertyChangeEvent(this, "DecreaseRPM", this.labelRPM.getText(),
                        Integer.valueOf(this.engine.getCurrentRpm() - 100)));

            }

            if (this.viewState == ViewState.OFF) {
                labelState.setText("The switch is OFF.");
                labelState.setBackground(Color.GRAY);

                this.decreaseRPM.setEnabled(false);
                this.buttonOff.setEnabled(false);
                this.buttonOn.setEnabled(true);

                this.firePropertyChangeEvent(new PropertyChangeEvent(this, "EngineState",
                        State.ON, State.OFF));
            }

            updateRPMLabel();
        }
    }

    // View Listeners
    @Override
    public void addPropertyChangeListener(final PropertyChangeListener listener) {
        if (listener != null)
            this.viewListeners.add(listener);

    }

    @Override
    public void removePropertyChangeListener(final PropertyChangeListener listener) {
        if (listener != null)
            this.viewListeners.remove(listener);
    }

    private void firePropertyChangeEvent(final PropertyChangeEvent event) {

        for (final PropertyChangeListener listener : this.viewListeners) {
            listener.propertyChange(event);
        }
    }

    private final void handleEngineEvent(PropertyChangeEvent event) {

        if (event.getPropertyName() == "EngineState" && event.getNewValue() == State.ON) {
            LOG.info("View: Receiving Engine Event {}", event.getNewValue());
            this.viewState = ViewState.ON;
        }

        if (event.getPropertyName() == "EngineState" && event.getNewValue() == State.OFF) {
            LOG.info("View: Receiving Engine Event {}", event.getNewValue());
            this.viewState = ViewState.OFF;
        }

        if (event.getPropertyName() == "rpmIncrease") {
            LOG.info("View: Receiving rpmIncrease Event {}", event.getNewValue());
            this.viewState = ViewState.INCREASING;
        }

        if (event.getPropertyName() == "rpmDecrease") {
            LOG.info("View: Receiving rpmDecrease Event {}", event.getNewValue());
            this.viewState = ViewState.DECREASING;
        }
    }

    private final void updateRPMLabel() {
        this.labelRPM.setText("RPM: " + this.engine.getCurrentRpm());
    }

    private final void rpmError() {
        Object[] options = { "Turn down RPM",
                "Exit Application!" };

        int n = JOptionPane.showOptionDialog(this,
                "RPM is too high!",
                "How do you want to proceed?",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE,
                this.icon, // do not use a custom Icon
                options, // the titles of buttons
                options[0]); // default button title

        if (n == JOptionPane.NO_OPTION) {
            System.exit(0);
        } else if (n == JOptionPane.YES_OPTION) {
            this.firePropertyChangeEvent(new PropertyChangeEvent(this, "DecreaseRPM", this.labelRPM.getText(),
                    Integer.valueOf(this.engine.getCurrentRpm() - 100)));

            updateRPMLabel();

            LOG.info("Reducing RPM!");
        }
    }

    private final void runErrorCycle() {
        counter++;

        if (counter % 3 == 0) {
            System.out.println(counter % 3);

            Object[] options = { "Clear Error and Continue!",
                    "Exit Application!" };

            int n = JOptionPane.showOptionDialog(this,
                    "Engine Error!",
                    "How do you want to proceed?",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE,
                    this.icon, // do not use a custom Icon
                    options, // the titles of buttons
                    options[0]); // default button title

            if (n == JOptionPane.NO_OPTION) {
                System.exit(0);
            } else if (n == JOptionPane.YES_OPTION) {
                LOG.info("Clearing Error!");
            }
        }
    }

}
