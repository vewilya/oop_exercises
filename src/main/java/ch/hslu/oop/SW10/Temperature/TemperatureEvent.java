package ch.hslu.oop.SW10.Temperature;

import java.io.Serializable;
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
