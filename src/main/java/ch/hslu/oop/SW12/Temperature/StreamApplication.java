package ch.hslu.oop.SW12.Temperature;

import java.time.LocalDateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class StreamApplication {
    public StreamApplication() {
        // default constructor
    }

    private static final Logger LOG = LoggerFactory.getLogger(StreamApplication.class);

    public static void main(String[] args) {
        TemperaturePointHistory tpH = new TemperaturePointHistory();

        tpH.add(new TemperaturePoint(Temperature.createFromCelsius(23.f), LocalDateTime.now()));
        tpH.add(new TemperaturePoint(Temperature.createFromCelsius(13.f), LocalDateTime.now()));
        tpH.add(new TemperaturePoint(Temperature.createFromCelsius(413.f), LocalDateTime.now()));
        tpH.add(new TemperaturePoint(Temperature.createFromCelsius(763.f), LocalDateTime.now()));
        tpH.add(new TemperaturePoint(Temperature.createFromCelsius(43.f), LocalDateTime.now()));
        tpH.add(new TemperaturePoint(Temperature.createFromCelsius(-13.f), LocalDateTime.now()));

        tpH.add(new TemperaturePoint(Temperature.createFromCelsius(-33.3f), LocalDateTime.now()));
        tpH.add(new TemperaturePoint(Temperature.createFromCelsius(-233.3f), LocalDateTime.now()));
    }
}
