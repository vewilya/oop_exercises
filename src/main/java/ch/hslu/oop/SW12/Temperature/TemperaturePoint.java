package ch.hslu.oop.SW12.Temperature;

import java.time.LocalDateTime;
import java.util.Objects;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TemperaturePoint implements Comparable<TemperaturePoint> {
    
    private LocalDateTime localDateTime; 
    private Temperature temperature;

    private static final Logger LOG = LoggerFactory.getLogger(TemperaturePoint.class);

    public TemperaturePoint(final Temperature temperature, final LocalDateTime ldt) {
        try {
            this.temperature = Temperature.createFromCelsius(temperature.getTemperatureCelsius());
            this.localDateTime = ldt;
        } catch (NullPointerException npe) {
            LOG.error(npe.getMessage(), npe);
        }
    }

    public static TemperaturePoint createFromTemperaturePoint(final TemperaturePoint temperaturePoint) {
        return new TemperaturePoint(temperaturePoint.getTemperature(), temperaturePoint.getLDT());
    }

    public final LocalDateTime getLDT() {
        return this.localDateTime;
    }

    public final Temperature getTemperature() {
        return this.temperature;
    }

    // ---------------------- Equals and HashCode Method Override ---------------------- //
   
    @Override
    public final boolean equals(final Object object) { 
        if (object == this) {
            return true;
        }
        
        return (object instanceof TemperaturePoint tP)
            && Objects.equals(tP.getTemperature(), this.getTemperature()) 
            && Objects.equals(tP.getLDT(), this.getLDT());
    }

    @Override
    public final int hashCode() {
        return Objects.hash(this.temperature, this.localDateTime);
    }


    // ---------------------- CompareTo Method Override ---------------------- //

    @Override
    public int compareTo(TemperaturePoint otherTemperaturePoint) {
        return Float.compare(this.getTemperature().getTemperatureCelsius(), otherTemperaturePoint.getTemperature().getTemperatureCelsius());
    }
}
