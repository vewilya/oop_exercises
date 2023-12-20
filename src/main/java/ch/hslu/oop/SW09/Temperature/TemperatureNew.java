package ch.hslu.oop.SW09.Temperature;

import java.util.Objects;

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
 * @version 1.0 from 2023-11-12
 * @author Urs Bollhalder
 */

public final class TemperatureNew implements Comparable<TemperatureNew> {

    // public static void main(String[] args) throws MyTypeErrorException {
    // TemperatureNew nT = TemperatureNew.createFromCelsius(-1223.f);

    // System.out.println(nT.getTemperatureCelsius());
    // }

    /**
     * Our main attribute holding the current temperature in Celsius.
     */
    private float temperatureCelsius;
    private static final float KELVIN_OFFSET = 273.15f;
    private static final float LOW_TEMPERATURE_LIMIT = -273.15f;

    /**
     * Default constructor
     */
    private TemperatureNew() {
        // initialise temperature to 20 degrees Ceslius when constructing the object.
        this.temperatureCelsius = 20.0f;
    }

    /**
     * Constructor with a given parameter temperature in Celsius.
     * 
     * @param tempInCelsius The temperature in Celsius
     */
    private TemperatureNew(final float tempInCelsius) {
        // Set temperature according to given parameter value
        this.temperatureCelsius = tempInCelsius;
    }

    public static TemperatureNew createFromCelsius(final float celsius) throws MyTypeErrorException {
        if (Temperature.convertCelsiusToKelvin(celsius) < TemperatureNew.LOW_TEMPERATURE_LIMIT) {
            throw new MyTypeErrorException("Temperature value is exceeding Low Temperature Limit!");
        }

        return new TemperatureNew(celsius);
    }

    public static TemperatureNew createFromKelvin(final float kelvin) throws MyTypeErrorException {
        if (kelvin < TemperatureNew.LOW_TEMPERATURE_LIMIT) {
            throw new MyTypeErrorException("Temperature value is exceeding Low Temperature Limit!");
        }

        return new TemperatureNew(TemperatureNew.convertKelvintoCelsius(kelvin));
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
     * Returns the current temperature in Fahrenheit.
     * 
     * @return The current temperature in Fahrenheit
     */
    public float getTempFahrenheit() {
        return (this.temperatureCelsius * 1.8f) + 32.0f;
    }

    /**
     * Returns the current temperature in Kelvin.
     * 
     * @return The current temperature in Kelvin
     *
     */
    public float getTempKelvin() {
        return this.temperatureCelsius + KELVIN_OFFSET;
    }

    /**
     * Changes the current temperature with a relative delta value in Celsius.
     * 
     * @param tempChangeCelsius The temperature delta value in Celsius
     */
    public void changeTempRelativeCelsius(float tempChangeCelsius) {
        float temperatureCheck = this.temperatureCelsius + tempChangeCelsius;

        // Check for LOW_TEMPERATURE_LIMIT
        if (TemperatureNew.convertCelsiusToKelvin(temperatureCheck) < TemperatureNew.LOW_TEMPERATURE_LIMIT) {
            throw new IllegalArgumentException("Temperature value is exceeding Low Temperature Limit!");
        }

        this.temperatureCelsius += tempChangeCelsius;
    }

    /**
     * Changes the current temperature with a relative delta value in Kelvin.
     * 
     * @param tempChangeKelvin The temperature delta value in Kelvin
     */
    public void changeTempRelativeKelvin(float tempChangeKelvin) {
        // Calculate our Kelvin temperature
        float newTemp = getTempKelvin() + tempChangeKelvin;

        // Check for LOW_TEMPERATURE_LIMIT
        if (TemperatureNew.convertCelsiusToKelvin(newTemp) < TemperatureNew.LOW_TEMPERATURE_LIMIT) {
            throw new IllegalArgumentException("Temperature value is exceeding Low Temperature Limit!");
        }

        // Update our main temperature variable
        this.temperatureCelsius = Temperature.convertKelvinToCelsius(newTemp);
    }

    // ---------------------- toString Mtehod Override ------------------------ //

    /**
     * Overides the toString method, returning a string containing the temperature
     * object with its attribute.
     */
    @Override
    public String toString() {
        return "Temperature [ Celsius=" + this.getTemperatureCelsius() + ", Kelvin=" + this.getTempKelvin()
                + ", Fahrenheit=" + this.getTempFahrenheit() + " ]";
    }

    // ---------------------- Equals and HashCode Method Override
    // ---------------------- //

    /**
     * Overides the equals method, returning a boolean value if the given object is
     * equal to the current object.
     * 
     * @param object The object to compare it with
     * @return A boolean value if the given object is equal to the current object.
     */
    @Override
    public boolean equals(final Object object) {
        if (object == this) {
            return true;
        }

        return (object instanceof TemperatureNew t)
                && Float.compare(t.temperatureCelsius, this.temperatureCelsius) == 0;
    }

    /**
     * Overides the hashCode method, returning a hash value of the current object.
     * 
     * @return The hash value of the current object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(this.temperatureCelsius);
    }

    // ---------------------- CompareTo Method Override ---------------------- //
    /**
     * Overides the compareTo method, comparing the current object with the given
     * object.
     * 
     * @param otherTemperature The object to compare it with
     * @return Returns 1 if the current object is bigger, -1 if the given object is
     *         bigger and 0 if they are equal.
     */
    @Override
    public int compareTo(TemperatureNew otherTemperature) {
        return Float.compare(this.temperatureCelsius, otherTemperature.temperatureCelsius);
    }

    // ---------------------- Static Methods ---------------------- //
    /**
     * Converts the current temperature Celsius to Fahrenheit.
     * 
     * @param tempInFahrenheit The new temperature in Fahrenheit
     * @return The converted Fahrenheit temperature in Celsius
     */
    public static float convertFahrenheitToCelsius(float tempInFahrenheit) {
        return (tempInFahrenheit - 32f) * 1.8f;
    }

    /**
     * Converts the current temperature Celsius to Kelvin.
     * 
     * @param tempInCelsius The new temperature in Kelvin
     * @return The converted Ceslius temperature in Fahrenheit
     */
    public static float convertCelsiusToFahrenheit(float tempInCelsius) {
        return (tempInCelsius * 1.8f) + 32f;
    }

    /**
     * Converts the current temperature Celsius to Kelvin.
     * 
     * @param tempInCelsius The temperature in Celsius to convert to Kelvin
     * @return The converted Celsius temperature in Kelvin
     */
    public static float convertCelsiusToKelvin(float tempInCelsius) {
        return tempInCelsius + KELVIN_OFFSET;
    }

    /**
     * Converts the current temperature Kelvin to Celsius.
     * 
     * @param tempInKelvin The temperature in Kelvin to convert to Celsius
     * @return The converted Kelvin temperature in Celsius
     */
    public static float convertKelvintoCelsius(float tempInKelvin) {
        return tempInKelvin - KELVIN_OFFSET;
    }
}
