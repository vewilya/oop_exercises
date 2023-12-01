package ch.hslu.oop.SW10.Car;

public enum State {
    ON("is switched on"), OFF("is switched off"), FAILURE("is failing"); 

    private final String stateDescription;

    private State(final String state) {
        this.stateDescription = state;
    }

    public String toString() {
        return this.stateDescription;
    }
}
