package ch.hslu.oop.SW11.Temperature;

import java.util.EventListener;

/*
 * The TemperatureEventListener Interface inherits from the EventListener interface and 
 * has a temperatureEventChange method, that is responsible  
 */
public interface TemperatureEventListener extends EventListener {

    void temperatureEventChange(TemperatureEvent temperatureEvent);
}
