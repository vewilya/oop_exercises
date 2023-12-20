package ch.hslu.oop.SW08.Element;

/**
 * Enum Aggregate State with 3 states for chemical elements Solid, Liquid,
 * Gaseous
 */
public enum AggregateState {
    /**
     * Solid State
     */
    SOLID("Solid"),

    /**
     * Liquid State
     */
    LIQUID("Liquid"),

    /**
     * Gaseous State
     */
    GASEOUS("Gaseous");

    private String aggregateState;

    private AggregateState(final String aggregateState) {
        this.aggregateState = aggregateState;
    }

    public String toString() {
        return this.aggregateState.toString();
    }
}
