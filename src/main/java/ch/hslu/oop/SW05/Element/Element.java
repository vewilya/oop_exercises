package ch.hslu.oop.SW05.Element;

/**
 * The half-abstract <code>Element</code> class represents an element with a
 * given name, boiling and evaporation point.
 *
 * @author Urs Bollhalder
 * @version 1.0 from 2023-19-10
 * @see ch.hslu.oop.SW05.Element.Lead
 * @see ch.hslu.oop.SW05.Element.Mercury
 * @see ch.hslu.oop.SW05.Element.Nitrogen
 */
public abstract class Element {

    /**
     * Constructor taking in a name, boiling and evaporation point.
     *
     * @param name             The name of the element.
     * @param evaporationPoint The evaporation point of the element.
     * @param boilingPoint     The boiling point of the element.
     */
    protected Element(String name, float boilingPoint, float evaporationPoint) {
        this.name = name;
        this.boilingPoint = boilingPoint;
        this.evaporationPoint = evaporationPoint;
    }

    /**
     * Returns the aggregate state of the element for a given temperature value in
     * Celsius.
     *
     * @param temperature The temperature to check.
     * @return The string for aggregate state of the element
     */
    public String getAggregateState(float temperature) {
        if (temperature < this.boilingPoint)
            return "solid";
        else if (temperature >= this.boilingPoint && temperature < this.evaporationPoint)
            return "liquid";
        else
            return "gaseous";
    }

    public String getAggreateState(Temperature temperature) {

        float elementTemperature = temperature.getTemperatureCelsius();

        if (elementTemperature < this.boilingPoint)
            return "solid";
        else if (elementTemperature >= this.boilingPoint && elementTemperature < this.evaporationPoint)
            return "liquid";
        else
            return "gaseous";
    }

    public float getEvaporationPoint() {
        return this.evaporationPoint;
    }

    public float getBolilingPoint() {
        return this.boilingPoint;
    }

    public String getString() {
        return this.name;
    }

    // -------------------- PRIVATE --------------------
    /**
     * Name of the element.
     */
    String name;

    /**
     * Evaporation point of the element.
     */
    float evaporationPoint;

    /**
     * Boiling point of the element.
     */
    float boilingPoint;

}
