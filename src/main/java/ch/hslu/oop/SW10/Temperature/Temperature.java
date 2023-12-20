package ch.hslu.oop.SW10.Temperature;

import java.util.Objects;

public final class Temperature implements Comparable<Temperature> {

    private float temperatureCelsius;
    private static final float KELVIN_OFFSET = 273.15f;
    private static final float LOW_TEMPERATURE_LIMIT = -273.15f;

    private Temperature() {
        // initialise temperature to 20 degrees Ceslius when constructing the object.
        this.temperatureCelsius = 20.0f;
    }

    private Temperature(final float tempInCelsius) {
        if (Temperature.convertCelsiusToKelvin(tempInCelsius) < Temperature.LOW_TEMPERATURE_LIMIT) {
            throw new IllegalArgumentException(
                    "Temperature value is exceeding Low Temperature Limit! value should not be lower than -273.15 Kelvin or "
                            + Temperature.convertKelvinToCelsius(LOW_TEMPERATURE_LIMIT) + " Celsius repectively!");
        }
        // Set temperature according to given parameter value
        this.temperatureCelsius = tempInCelsius;
    }

    public static Temperature createFromCelsius(final float celsius) {

        return new Temperature(celsius);
    }

    public static Temperature createFromKelvin(final float kelvin) {

        return new Temperature(Temperature.convertKelvinToCelsius(kelvin));
    }

    public static Temperature createFromTemperature(final Temperature temperature) {
        return new Temperature(temperature.getTemperatureCelsius());
    }

    public float getTemperatureCelsius() {
        return this.temperatureCelsius;
    }

    public float getTempFahrenheit() {
        return (this.temperatureCelsius * 1.8f) + 32.0f;
    }

    public float getTempKelvin() {
        return this.temperatureCelsius + KELVIN_OFFSET;
    }

    public void changeTempRelativeCelsius(float tempChangeCelsius) {
        float temperatureCheck = this.temperatureCelsius + tempChangeCelsius;

        // Check for LOW_TEMPERATURE_LIMIT
        if (Temperature.convertCelsiusToKelvin(temperatureCheck) < Temperature.LOW_TEMPERATURE_LIMIT) {
            throw new IllegalArgumentException("Temperature value is exceeding Low Temperature Limit!");
        }

        this.temperatureCelsius += tempChangeCelsius;
    }

    public void changeTempRelativeKelvin(float tempChangeKelvin) {
        // Calculate our Kelvin temperature
        float newTemp = getTempKelvin() + tempChangeKelvin;

        // Check for LOW_TEMPERATURE_LIMIT
        if (Temperature.convertCelsiusToKelvin(newTemp) < Temperature.LOW_TEMPERATURE_LIMIT) {
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
        return "Temperature [ Celsius = " + this.getTemperatureCelsius() + ", Kelvin = " + this.getTempKelvin()
                + ", Fahrenheit = " + this.getTempFahrenheit() + " ]";
    }

    // ---------------------- Equals and HashCode Method Override
    // ---------------------- //

    @Override
    public boolean equals(final Object object) {
        if (object == this) {
            return true;
        }

        return (object instanceof Temperature t)
                && Float.compare(t.temperatureCelsius, this.temperatureCelsius) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.temperatureCelsius);
    }

    // ---------------------- CompareTo Method Override ---------------------- //

    @Override
    public int compareTo(Temperature otherTemperature) {
        return Float.compare(this.getTemperatureCelsius(), otherTemperature.getTemperatureCelsius());
    }

    // ---------------------- Static Methods ---------------------- //

    public static float convertFahrenheitToCelsius(float tempInFahrenheit) {
        return (tempInFahrenheit - 32f) * 1.8f;
    }

    public static float convertCelsiusToFahrenheit(float tempInCelsius) {
        return (tempInCelsius * 1.8f) + 32f;
    }

    public static float convertCelsiusToKelvin(float tempInCelsius) {
        return tempInCelsius + KELVIN_OFFSET;
    }

    public static float convertKelvinToCelsius(float tempInKelvin) {
        return tempInKelvin - KELVIN_OFFSET;
    }
}
