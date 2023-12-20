package ch.hslu.oop.SW12.Temperature;

import java.util.EventObject;

public final class TemperatureEvent extends EventObject {

    private TemperatureEventType temperatureEventType;
    private Temperature newTemperatureExtrema;

    public TemperatureEvent(Object source, Temperature temperature, TemperatureEventType eventType) {
        super(source);
        this.newTemperatureExtrema = temperature;
        this.temperatureEventType = eventType;
    }

    public TemperatureEventType getTemperatureEventType() {

        return this.temperatureEventType;
    }

}
