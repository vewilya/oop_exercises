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
    private final Engine engine;

    private final JLabel labelState = new JLabel("Engine is OFF");
    private final JButton buttonOn = new JButton("On");
    private final JButton buttonOff = new JButton("Off");

    private final JButton increaseRPM = new JButton("Increase RPM");
    private final JLabel labelRPM = new JLabel("RPM: 0");
    private final JButton decreaseRPM = new JButton("Decrease RPM");

    private final ImageIcon icon;

    private int counter = 0;

    /**
     * Konstruktor.
     */
    public EngineView(final Engine engine) {
        super("EngineView");

        this.engine = engine;

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
            this.labelState.setText("Engine is ON.");
            this.labelState.setBackground(Color.GREEN);

            this.buttonOff.setEnabled(true);
            this.buttonOn.setEnabled(false);

            this.firePropertyChangeEvent(new PropertyChangeEvent(this, "EngineState", State.OFF, State.ON));
            updateRPM();
            runErrorCycle();
            LOG.info("ActionEvent von ON-Button empfangen und verarbeitet.");
        }

        if (event.getSource() == buttonOff) {
            labelState.setText("Engine is OFF");
            labelState.setBackground(Color.GRAY);

            this.buttonOff.setEnabled(false);
            this.buttonOn.setEnabled(true);
            this.decreaseRPM.setEnabled(false);

            this.firePropertyChangeEvent(new PropertyChangeEvent(this, "EngineState", State.ON, State.OFF));
            updateRPM();
            LOG.info("ActionEvent von ON-Button empfangen und verarbeitet.");
        }

        if (event.getSource() == increaseRPM) {
            LOG.info("Increase RPM-Button pressed.");

            if (this.engine.getCurrentRpm() == 0) {
                this.labelState.setText("Engine is ON");
                this.labelState.setBackground(Color.GREEN);
                this.decreaseRPM.setEnabled(true);
                this.buttonOff.setEnabled(true);

                this.firePropertyChangeEvent(new PropertyChangeEvent(this, "EngineState", State.OFF, State.ON));
            } else {
                this.decreaseRPM.setEnabled(true);
                this.firePropertyChangeEvent(new PropertyChangeEvent(this, "increaseRPM",
                        this.labelRPM.getText(), Integer.valueOf(this.engine.getCurrentRpm() + 100)));

                if (this.engine.getCurrentRpm() > 2000) {
                    rpmError();
                }
            }

            updateRPM();
        }

        if (event.getSource() == decreaseRPM) {
            LOG.info("Decrease RPM-Button pressed.");

            if (this.engine.getCurrentRpm() > 0) {
                this.firePropertyChangeEvent(new PropertyChangeEvent(this, "DecreaseRPM", this.labelRPM.getText(),
                        Integer.valueOf(this.engine.getCurrentRpm() - 100)));

            }

            if (this.engine.getCurrentRpm() == 0) {
                labelState.setText("The switch is OFF.");
                labelState.setBackground(Color.GRAY);

                this.decreaseRPM.setEnabled(false);
                this.buttonOff.setEnabled(false);

                this.firePropertyChangeEvent(new PropertyChangeEvent(this, "EngineState", State.ON, State.OFF));
            }

            updateRPM();
        }
    }

    // View Listeners
    public void addPropertyChangeListener(final PropertyChangeListener listener) {
        try {
            this.viewListeners.add(listener);
        } catch (NullPointerException npe) {
            LOG.error("There is no listener object being handed over", npe.getMessage());
        }
    }

    public void removePropertyChangeListener(final PropertyChangeListener listener) {
        try {
            this.viewListeners.remove(listener);
        } catch (NullPointerException npe) {
            LOG.error("There is no listener object being handed over", npe.getMessage());
        }
    }

    private void firePropertyChangeEvent(final PropertyChangeEvent event) {

        for (final PropertyChangeListener listener : this.viewListeners) {
            listener.propertyChange(event);
        }
    }

    private final void updateRPM() {
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

            updateRPM();

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
