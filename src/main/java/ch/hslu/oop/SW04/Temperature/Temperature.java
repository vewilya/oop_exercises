package ch.hslu.oop.SW04.Temperature;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

/**
 * The <code>Temperature</code> class represents a temperature value in Celsius.
 *
 * <p>
 * It provides methods to convert the temperature to Fahrenheit and Kelvin, as
 * we as returning
 * current temperature in these units of measurement as well as methods to
 * change the temperature relatively
 * with a given temperature delta value.
 *
 * <p>
 * The <code>Temperature</code> class furthermore implemnts methods to return
 * the state of a given element at the current temperature.
 *
 * @version 1.0 from 2020-10-06
 * @author Urs Bollhalder
 */

public final class Temperature {

    /**
     * Our main attribute holding the current temperature in Celsius.
     */
    private float temperatureCelsius;
    private static final Logger LOG = LoggerFactory.getLogger(Temperature.class);

    /**
     * Default constructor
     */
    public Temperature() {
        // initialise temperature to 20 degrees Ceslius when constructing the object.
        this.temperatureCelsius = 20.0f;
    }

    /**
     * Constructor with a given parameter temperature in Celsius.
     *
     * @param tempInCelsius The temperature in Celsius
     */
    public Temperature(float tempInCelsius) {
        // Set temperature according to given parameter value
        this.temperatureCelsius = tempInCelsius;
    }

    /**
     * Returns the current temperature in Celsius.
     *
     * @return The current temperature in Celsius
     */
    public float getTemperatureCelsius() {
        return this.temperatureCelsius;
    }

    /**
     * Sets the current temperature in Celsius.
     *
     * @param tempInCelsius The new temperature in Celsius
     */
    public void setTemperatureCelsius(final float tempInCelsius) {
        this.temperatureCelsius = tempInCelsius;
    }

    /**
     * Returns the current temperature in Fahrenheit.
     *
     * @return The current temperature in Fahrenheit
     */
    public float getTempFahrenheit() {
        return (this.temperatureCelsius * 1.8f) + 32f;
    }

    /**
     * Returns the current temperature in Kelvin.
     *
     * @return The current temperature in Kelvin
     *
     */
    public float getTempKelvin() {
        return this.temperatureCelsius + 273.15f;
    }

    /**
     * Converts the current temperature Celsius to Fahrenheit.
     *
     * @param tempInFahrenheit The new temperature in Fahrenheit
     * @return The converted Fahrenheit temperature in Celsius
     */
    public float fahrenheitToCelsius(final float tempInFahrenheit) {
        return (tempInFahrenheit - 32f) * 1.8f;
    }

    /**
     * Converts the current temperature Celsius to Kelvin.
     *
     * @param tempInCelsius The new temperature in Kelvin
     * @return The converted Ceslius temperature in Fahrenheit
     */
    public float celsiusToFahrenheit(final float tempInCelsius) {
        return (tempInCelsius * 1.8f) + 32f;
    }

    /**
     * Converts the current temperature Celsius to Kelvin.
     *
     * @param tempInCelsius The new temperature in Celsius
     * @return The converted Celsius temperature in Kelvin
     */
    public float celsiusToKelvin(final float tempInCelsius) {
        return tempInCelsius + 273.15f;
    }

    /**
     * Changes the current temperature with a relative delta value in Celsius.
     *
     * @param tempChangeCelsius The temperature delta value in Celsius
     */
    public void changeTempRelativeCelsius(final float tempChangeCelsius) {
        this.temperatureCelsius += tempChangeCelsius;
    }

    /**
     * Changes the current temperature with a relative delta value in Kelvin.
     *
     * @param tempChangeKelvin The temperature delta value in Kelvin
     */
    public void changeTempRelativeKelvin(final float tempChangeKelvin) {
        // Calculate our Kelvin temperature
        float newTemp = getTempKelvin() + tempChangeKelvin;

        // Update our main temperature variable
        this.temperatureCelsius = newTemp - 273.15f;
    }

    /**
     * Returns the state of the given element at the current temperature.
     *
     * @param element The element to check for its aggrgate state
     * @return The aggregate state of the given element.
     */
    public String getStateOfElement(String element) {
        String state = "solid";

        switch (element) {

            case "Hg":
                if (temperatureCelsius < -38.83f) {
                    state = "solid";
                } else if (temperatureCelsius >= -38.83f) {
                    state = "liquid";
                } else if (temperatureCelsius >= 357.0f) {
                    state = "gaseous";
                }
                break;

            case "Pb":
                if (temperatureCelsius < 327.43f) {
                    state = "solid";
                } else if (temperatureCelsius >= 327.43f) {
                    state = "liquid";
                } else if (temperatureCelsius >= 1744.0f) {
                    state = "gaseous";
                }
                break;

            case "N":
                if (temperatureCelsius < -210.1f) {
                    state = "solid";
                } else if (temperatureCelsius >= -210.1f) {
                    state = "liquid";
                } else if (temperatureCelsius >= -196.0f) {
                    state = "gaseous";
                }
                break;
            default:
                state = "unknown";
        }

        return state;
    }

    /**
     * Returns the state of the given element at the current temperature
     *
     * @param element The element to check
     * @return The aggregate state of the given element
     */
    public String getStateOfElements(String element) {
        String[] elements = { "Hg", "Pb", "N" };
        float[] boilingPoints = { -38.83f, 327.43f, -210.1f };
        float[] evaporationPoints = { 357.0f, 1744.0f, -196.0f };

        String state = "solid";

        for (int i = 0; i < elements.length; i++) {
            if (element.equals(elements[i])) {

                // Check States
                if (temperatureCelsius < boilingPoints[i]) {
                    state = "solid";
                    LOG.info("State is {}", state);
                } else if (temperatureCelsius >= boilingPoints[i]) {
                    state = "liquid";
                    LOG.info("State is {}", state);
                } else if (temperatureCelsius >= evaporationPoints[i]) {
                    state = "gaseous";
                    LOG.info("State is {}", state);
                }

            }
        }

        return state;
    }
}

// Martin Fowler: "Any fool can write code that a computer can understand. Good
// programmers write code that humans can understand."
