package ch.hslu.oop.SW08.Element;

import java.util.EnumMap;
import java.util.Objects;

import ch.hslu.oop.SW08.Temperature.Temperature;

/**
 * The half-abstract <code>Element</code> class represents an element with a
 * given name, boiling and evaporation point.
 * 
 * @author Urs Bollhalder
 * @version 0.0.1 from 2023-13-11
 * @see ch.hslu.oop.8.Element.Lead
 * @see ch.hslu.oop.8.Element.Mercury
 * @see ch.hslu.oop.8.Element.Nitrogen
 */
public abstract class Element implements Comparable<Element> {

    // -------------------- Private -------------------- //

    private final String name;
    private final int atomicMass;
    private final ElementClassification classification;
    // private final float meltingPoint;
    // private final float evaporationPoint;
    private final EnumMap<AggregatePoints, Float> temperaturePointMap;
    
    private enum AggregatePoints {
        MELTING_POINT, EVAPORATION_POINT;
    }

    // -------------------- Constructor -------------------- //
    /**
     * Constructor taking in a name, boiling and evaporation point.
     * @param name             The name of the element.
     * @param meltingPoint     The melting point of the element.
     * @param evaporationPoint The evaporation point of the element.
     */
    protected Element(String name, int atomicMass, ElementClassification classification, float meltingPoint,
            float evaporationPoint) {
        this.name = name;
        this.atomicMass = atomicMass;
        this.classification = classification;
        // this.meltingPoint = meltingPoint;
        // this.evaporationPoint = evaporationPoint;

        temperaturePointMap = new EnumMap<>(AggregatePoints.class);
        temperaturePointMap.put(AggregatePoints.MELTING_POINT, meltingPoint);
        temperaturePointMap.put(AggregatePoints.EVAPORATION_POINT, evaporationPoint);
    }

    // -------------------- Getters and Setters -------------------- //
    /**
     * Returns the aggregate state of the element for a given temperature value in
     * Celsius.
     * 
     * @param temperature The temperature to check.
     * @return The string for aggregate state of the element
     */
    public AggregateState getAggregateState(float temperature) {

        if (temperature < temperaturePointMap.get(AggregatePoints.MELTING_POINT))
            return AggregateState.SOLID;
        else if (temperature >= temperaturePointMap.get(AggregatePoints.MELTING_POINT)
                && temperature < temperaturePointMap.get(AggregatePoints.EVAPORATION_POINT))
            return AggregateState.LIQUID;
        else
            return AggregateState.GASEOUS;
    }

    /**
     * Returns the aggregate state of the element for a given temperature object.
     * @param temperature The temperature object to check.
     * @return The string for aggregate state of the element
     */
    public AggregateState getAggreateState(Temperature temperature) {

        float elementTemperature = temperature.getTemperatureCelsius();

        if (elementTemperature < temperaturePointMap.get(AggregatePoints.MELTING_POINT))
            return AggregateState.SOLID;
        else if (elementTemperature >= temperaturePointMap.get(AggregatePoints.MELTING_POINT)
                && elementTemperature < temperaturePointMap.get(AggregatePoints.EVAPORATION_POINT))
            return AggregateState.LIQUID;
        else
            return AggregateState.GASEOUS;
    }

    /**
     * Returns the evaporation point of the element.
     * 
     * @return The evaporation point of the element
     */
    public float getEvaporationPoint() {
        return temperaturePointMap.get(AggregatePoints.EVAPORATION_POINT);
    }

    /**
     * Returns the boiling point of the element.
     * 
     * @return The boiling point of the element.
     */
    public float getBoilingPoint() {
        return temperaturePointMap.get(AggregatePoints.MELTING_POINT);
    }

    /**
     * Returns the class name of the element.
     * 
     * @return The class name of the element.
     */
    public String getElementClassification() {
        return this.classification.toString();
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
                + this.classification + ", Melting Point: " + temperaturePointMap.get(AggregatePoints.MELTING_POINT)
                + ", Evaporation Point: " + temperaturePointMap.get(AggregatePoints.EVAPORATION_POINT) + " ]";
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
