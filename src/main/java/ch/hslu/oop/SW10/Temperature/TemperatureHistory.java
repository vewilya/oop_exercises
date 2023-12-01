package ch.hslu.oop.SW10.Temperature;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class TemperatureHistory implements Comparable<TemperatureHistory> {

    // ------------------------------ Attributes ---------------------------- //
    private final Collection<Temperature> temperatureHistory = new ArrayList<>();

    private Temperature minTempCache;
    private Temperature maxTempCache;
  
    private final List<TemperatureEventListener> changeListeners = new ArrayList<>();
    
    private static final Logger LOG = LoggerFactory.getLogger(TemperatureHistory.class);
    
    // Defaault Constructor
    public TemperatureHistory() {}

    public void add(final Temperature temperature) {
        
        try {
            checkTemperatureExtrema(temperature);
            this.temperatureHistory.add(temperature);
        } catch (NullPointerException npe) {
            throw new NullPointerException("The given temperature object is null");
            
            // LOG.info("The given temperature object is null", npe.getMessage());
        }
        
        
    }

    public void clear() {
        if (this.getCount() > 0) 

            // We need to clear out our temperature history.
            this.temperatureHistory.clear();

            // Reset our maxima temp caches as well.
            this.maxTempCache = null;
            this.minTempCache = null;
    }

    public void checkTemperatureExtrema(final Temperature temperature) {
       
        if (minTempCache != null) {
            if (temperature.compareTo(minTempCache) == -1) {
                minTempCache = Temperature.createFromTemperature(temperature);
                fireTemperatureEvent(new TemperatureEvent(this, Temperature.createFromTemperature(temperature), TemperatureEventType.MIN));
                LOG.info("New Minimum Temperature: {}", temperature.getTemperatureCelsius());    
            }
        } else {
            minTempCache = Temperature.createFromTemperature(temperature);
            fireTemperatureEvent(new TemperatureEvent(this, Temperature.createFromTemperature(temperature), TemperatureEventType.MIN));
            LOG.info("New Minimum Temperature: {}", temperature.getTemperatureCelsius());    
        }

        
        if (maxTempCache != null) {
            if (temperature.compareTo(maxTempCache) == 1) {
                maxTempCache = Temperature.createFromTemperature(temperature);
                fireTemperatureEvent(new TemperatureEvent(this, Temperature.createFromTemperature(temperature), TemperatureEventType.MAX));
                LOG.info("New Maximum Temperature: {}", temperature.getTemperatureCelsius());
            }
        } else {
            maxTempCache = Temperature.createFromTemperature(temperature);
            fireTemperatureEvent(new TemperatureEvent(this, Temperature.createFromTemperature(temperature), TemperatureEventType.MAX));
            LOG.info("New Maximum Temperature: {}", temperature.getTemperatureCelsius());
        }
       
    }

    public int getCount() {
        return this.temperatureHistory.size();
    }

    public Temperature getMaxTemperature() {

        if (this.getCount() == 0) {
            return null;
        }

        // Ruft die compareTo()-methode auf
        // return Collections.max(this.temperatureHistory);
        return Temperature.createFromCelsius(Collections.max(this.temperatureHistory).getTemperatureCelsius());
    }

    public Temperature getMinTemperature() {

        if (this.getCount() == 0) {
            return null;
        }

        return Temperature.createFromCelsius(Collections.min(this.temperatureHistory).getTemperatureCelsius());
    }

    public Temperature getAverageTemperature() {
            
        if (this.getCount() == 0) {
            return null;
        } else {

            float average = 0;
    
            Iterator<Temperature> iterator = temperatureHistory.iterator();
            
            while(iterator.hasNext()) {
                final Temperature temp = iterator.next();                
                
                average += temp.getTemperatureCelsius();
            }
            
            average /= this.getCount();  
            
            return Temperature.createFromCelsius(average);
        }
    }


    public void addTemperatureEventListener(final TemperatureEventListener listener) {
        try {
            this.changeListeners.add(listener);
        } catch (NullPointerException npe) {
            LOG.error("Listener object that's being handed over is null!", npe.getMessage());
        }    
    }

    public void removeTemperatureEventListener(final TemperatureEventListener listener) {
        try {
            this.changeListeners.remove(listener);
        } catch (NullPointerException npe) {
            LOG.error("Listener object that's being handed over is null!", npe.getMessage());
        }
    }

    public void fireTemperatureEvent(final TemperatureEvent temperatureEvent) {
        try {
            for (final TemperatureEventListener listener : this.changeListeners) {
                listener.temperatureEventChange(temperatureEvent);
            }
        } catch (NullPointerException npe) {
            LOG.info("There are currently no changeListeners registered!", npe.getMessage());
        }
    }
    
    // ------------------------ // // ------------------------ // 

    @Override 
    public String toString() {
        return "Temperature History - Number of Temperatures: " + this.getCount() + ", \nMax Temperature: " + this.getMaxTemperature() + ", \nMin Temperature: " + this.getMinTemperature() + ", \nAverage Temperature: " + this.getAverageTemperature(); 
    }

    @Override
    public boolean equals(final Object object) { 
        if (object == this) {
            return true;
        }
        
        return (object instanceof TemperatureHistory tempDev)
            && (tempDev.getCount() == this.getCount()) 
            && (tempDev.getMaxTemperature() == this.getMaxTemperature()) 
            && (tempDev.getMinTemperature() == this.getMinTemperature());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getCount());
    }

    @Override
    public int compareTo(TemperatureHistory otherTemperatureDevelopment) {
        return Float.compare(this.getCount(), otherTemperatureDevelopment.getCount());
    }



}
