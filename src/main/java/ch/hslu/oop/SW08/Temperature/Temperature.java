package ch.hslu.oop.SW08.Temperature;

import java.util.Objects;


/**
 * The <code>Temperature</code> class represents a temperature value in Celsius.
 * 
 * <p>It provides methods to convert the temperature to Fahrenheit and Kelvin, as we as returning
 * current temperature in these units of measurement as well as methods to change the temperature relatively 
 * with a given temperature delta value.
 * 
 * <p>The <code>Temperature</code> class furthermore implemnts methods to return the state of a given element at the current temperature.
 * 
 * @version 1.0 from 2023-11-12
 * @author Urs Bollhalder
 */

public final class Temperature implements Comparable<Temperature> {
    
    /**
     * Our main attribute holding the current temperature in Celsius.
     */
    private float temperatureCelsius;
    private static final float KELVIN_OFFSET = 273.15f;

    /**
     * Default constructor
     */
    public Temperature()
    {
        // initialise temperature to 20 degrees Ceslius when constructing the object.
        this.temperatureCelsius = 20.0f;
    }

    /**
     * Constructor with a given parameter temperature in Celsius.
     * @param tempInCelsius The temperature in Celsius
     */
    public Temperature(float tempInCelsius)
    {
        // Set temperature according to given parameter value 
        this.temperatureCelsius = tempInCelsius;
    }


    /**
     * Returns the current temperature in Celsius.
     * @return The current temperature in Celsius
     */
    public float getTemperatureCelsius()
    {
        return this.temperatureCelsius;
    }

    /**
     * Sets the current temperature in Celsius.
     * @param tempInCelsius The new temperature in Celsius
     */
    public void setTemperatureCelsius(final float tempInCelsius)
    {
        this.temperatureCelsius = tempInCelsius;
    }

    /**
     * Returns the current temperature in Fahrenheit.
     * @return The current temperature in Fahrenheit
     */
    public float getTempFahrenheit()
    {
        return (this.temperatureCelsius * 1.8f) + 32.0f;
    }
    
    /**
     * Returns the current temperature in Kelvin.
     * @return The current temperature in Kelvin
     * 
     */
    public float getTempKelvin()
    {
        return this.temperatureCelsius + KELVIN_OFFSET;
    }
    
    /**
     * Changes the current temperature with a relative delta value in Celsius.
     * @param tempChangeCelsius The temperature delta value in Celsius
     */
    public void changeTempRelativeCelsius(float tempChangeCelsius)
    {
        this.temperatureCelsius += tempChangeCelsius;
    }

    /**
     * Changes the current temperature with a relative delta value in Kelvin.
     * @param tempChangeKelvin The temperature delta value in Kelvin
     */
    public void changeTempRelativeKelvin(float tempChangeKelvin)
    {
        // Calculate our Kelvin temperature
        float newTemp = getTempKelvin() + tempChangeKelvin;
        
        // Update our main temperature variable
        this.temperatureCelsius = Temperature.convertKelvintoCelsius(newTemp);
    }

    /**
     * Returns the state of the given element at the current temperature.
     * @param element The element to check for its aggrgate state
     * @return The aggregate state of the given element.
     */
    public String getStateOfElement(String element)
    {
        String state = "solid";
        
        switch(element) {

            case "Hg":
                if (temperatureCelsius < -38.83f)
                    state = "solid";
                else if (temperatureCelsius >= -38.83f)
                    state = "liquid";
                else if (temperatureCelsius >= 357.0f)
                    state = "gaseous";
                break;
                
            case "Pb":
                if (temperatureCelsius < 327.43f)
                    state = "solid";
                else if (temperatureCelsius >= 327.43f)
                    state = "liquid";
                else if (temperatureCelsius >= 1744.0f)
                    state = "gaseous";
                break;

            case "N":
                if (temperatureCelsius < -210.1f)
                    state = "solid";
                else if (temperatureCelsius >= -210.1f )
                    state = "liquid";
                else if (temperatureCelsius >= -196.0f)
                    state = "gaseous";
                break;
            }

            return state;
    }

    /**
     * Returns the state of the given element at the current temperature
     * @param element The element to check
     * @return The aggregate state of the given element
     */
    public String getStateOfElements(String element)
    {
        String elements[] = { "Hg", "Pb", "N" };
        float boilingPoints[] = { -38.83f, 327.43f, -210.1f }; 
        float evaporationPoints[] = { 357.0f, 1744.0f, -196.0f};

        String state = "solid";
        
        for (int i = 0; i < elements.length; i++) {
            if (element == elements[i])
            {
                // Check index
                System.out.println(i); 
                
                // Check States
                if (temperatureCelsius < boilingPoints[i]) {
                    state = "solid";
                    System.out.println("solid"); 
                } else if (temperatureCelsius >= boilingPoints[i]) {
                    state = "liquid";
                    System.out.println("liquid"); 
                } else if (temperatureCelsius >= evaporationPoints[i]) {
                    state = "gaseous";
                    System.out.println("gaseous"); 
                }

            }
        }
        
        return state;
    }

    // ---------------------- Static Methods ---------------------- //
    /**
     * Converts the current temperature Celsius to Fahrenheit.
     * @param tempInFahrenheit The new temperature in Fahrenheit
     * @return The converted Fahrenheit temperature in Celsius
     */
    public static float convertFahrenheitToCelsius(float tempInFahrenheit)
    {
        return (tempInFahrenheit - 32f) * 1.8f;
    }
    
    /**
     * Converts the current temperature Celsius to Kelvin.
     * @param tempInCelsius The new temperature in Kelvin
     * @return The converted Ceslius temperature in Fahrenheit
     */
    public static float convertCelsiusToFahrenheit(float tempInCelsius) {
        return (tempInCelsius * 1.8f) + 32f;
    }   

    /**
     * Converts the current temperature Celsius to Kelvin.
     * @param tempInCelsius The temperature in Celsius to convert to Kelvin
     * @return The converted Celsius temperature in Kelvin
     */
    public static float convertCelsiusToKelvin(float tempInCelsius) {
        return tempInCelsius + KELVIN_OFFSET;
    }


    /**
     * Converts the current temperature Kelvin to Celsius.
     * @param tempInKelvin The temperature in Kelvin to convert to Celsius
     * @return The converted Kelvin temperature in Celsius
     */
    public static float convertKelvintoCelsius(float tempInKelvin) {
        return tempInKelvin - KELVIN_OFFSET;
    }

    // ---------------------- toString Mtehod Override ------------------------ //

    /**
     * Overides the toString method, returning a string containing the temperature object with its attribute.
     */
    @Override
    public String toString() {
        return "Temperature [ Celsius=" + this.getTemperatureCelsius() + ", Kelvin=" + this.getTempKelvin() + ", Fahrenheit=" + this.getTempFahrenheit() + " ]";
    }
    
    // ---------------------- Equals and HashCode Method Override ---------------------- //
   
    /**
     * Overides the equals method, returning a boolean value if the given object is equal to the current object.
     * @param object The object to compare it with
     * @return A boolean value if the given object is equal to the current object.
     */
    @Override
    public boolean equals(final Object object) { 
        if (object == this) {
            return true;
        }
        
        return (object instanceof Temperature t)
            && Float.compare(t.temperatureCelsius, this.temperatureCelsius) == 0;
    }

    /**
     * Overides the hashCode method, returning a hash value of the current object.
     * @return The hash value of the current object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(this.temperatureCelsius);
    }

    // ---------------------- CompareTo Method Override ---------------------- //
    /**
     * Overides the compareTo method, comparing the current object with the given object.
     * @param otherTemperature The object to compare it with
     * @return Returns 1 if the current object is bigger, -1 if the given object is bigger and 0 if they are equal.
     */
    @Override
    public int compareTo(Temperature otherTemperature) {
        return Float.compare(this.temperatureCelsius, otherTemperature.temperatureCelsius);
    }
    

}


