package ch.hslu.oop.SW08.Element;

public enum AggregateState {
    SOLID("Solid"), LIQUID("Liquid"), GASEOUS("Gaseous");

    private String aggregateState;

    private AggregateState(final String aggregateState) {
        this.aggregateState = aggregateState;
    }

    public String toString() {
        return this.aggregateState.toString();
    }
}
