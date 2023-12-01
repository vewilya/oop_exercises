package ch.hslu.oop.SW11.csvTemperatureRead;

import java.time.LocalDateTime;

public class MeasuringPoint {
    
    private float temperature;
    private LocalDateTime localDatetime; 

    public MeasuringPoint(final float temperature, final LocalDateTime ldt) {
        this.temperature = temperature;
        this.localDatetime = ldt;
    }


}
