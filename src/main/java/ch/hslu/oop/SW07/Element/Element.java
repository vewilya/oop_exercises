package ch.hslu.oop.SW07.Element;

import java.util.Objects;

import ch.hslu.oop.SW07.Temperature.Temperature;

/**
 * The half-abstract <code>Element</code> class represents an element with a
 * given name, boiling and evaporation point.
 * 
 * @author Urs Bollhalder
 * @version 1.0 from 2023-19-10
 * @see ch.hslu.oop.SW07.Element.Lead
 * @see ch.hslu.oop.SW07.Element.Mercury
 * @see ch.hslu.oop.SW07.Element.Nitrogen
 */
public abstract class Element implements Comparable<Element> {

    // -------------------- Private -------------------- //

    private final String name;
    private final int atomicMass;
    private final ElementClassification classification;
    private final float evaporationPoint;
    private final float boilingPoint;

    // -------------------- Enum -------------------- //
    public enum ElementClassification {
        ALKALI_METALS, ALKALINE_EARTH_METALS, TRANSITION_METALS, OTHER_METALS, METALLOIDS, NON_METALS, HALOGENS,
        NOBLE_GASES, RARE_EARTH_ELEMENTS
    }

    // -------------------- Constructor -------------------- //
    /**
     * Constructor taking in a name, boiling and evaporation point.
     * 
     * @param name             The name of the element.
     * @param evaporationPoint The evaporation point of the element.
     * @param boilingPoint     The boiling point of the element.
     */
    protected Element(String name, int atomicMass, ElementClassification classification, float boilingPoint,
            float evaporationPoint) {
        this.name = name;
        this.atomicMass = atomicMass;
        this.classification = classification;
        this.boilingPoint = boilingPoint;
        this.evaporationPoint = evaporationPoint;
    }

    // -------------------- Getters and Setters -------------------- //
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

    /**
     * Returns the evaporation point of the element.
     * 
     * @return The evaporation point of the element
     */
    public float getEvaporationPoint() {
        return this.evaporationPoint;
    }

    /**
     * Returns the boiling point of the element.
     * 
     * @return The boiling point of the element.
     */
    public float getBolilingPoint() {
        return this.boilingPoint;
    }

    /**
     * Returns the class name of the element.
     * 
     * @return The class name of the element.
     */
    public ElementClassification getElementClassification() {
        return this.classification;
    }

    /**
     * Returns atomic mass of the element as an integer.
     * 
     * @return The atomic mass of the element.
     */
    public int getAtomicMass() {
        return this.atomicMass;
    }

    // -------------------- ToString Method Override -------------------- //

    @Override
    public String toString() {
        return "[ Element: " + this.name + ", Atomic Mass: " + this.atomicMass + ", Classification: "
                + this.classification + ", Boiling Point: " + this.boilingPoint + ", Evaporation Point: "
                + this.evaporationPoint + " ]";
    }

    // -------------------- Equals and HashCode Method Override --------------------
    // //

    @Override
    public final boolean equals(final Object object) {
        if (object == this) {
            return true;
        }
        return (object instanceof Element e)
                && (e.classification == this.classification);
    }

    // Typengleichheit implementiert!
    // @Override
    // public final boolean equals(final Object object) {
    // if (object == this) {
    // return true;
    // }

    // return (object == null ? false : object.getClass().equals(this.getClass()));
    // }

    @Override
    public final int hashCode() {
        return Objects.hash(this.classification);
    }

    // ---------------------- CompareTo Method Override ---------------------- //
    /**
     * Compares the atomic mass of the element with the atomic mass of another
     * element.
     */
    @Override
    public final int compareTo(Element otherElement) {
        return Integer.compare(this.atomicMass, otherElement.atomicMass);
    }

}
