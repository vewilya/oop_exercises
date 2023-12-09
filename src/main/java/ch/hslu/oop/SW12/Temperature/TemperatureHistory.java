package ch.hslu.oop.SW12.Temperature;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class TemperatureHistory implements Comparable<TemperatureHistory> {

    // ------------------------------ Attributes ---------------------------- //
    private final Collection<TemperaturePoint> temperatureHistory = new ArrayList<>();
    private TemperaturePoint minTempCache;
    private TemperaturePoint maxTempCache;

    private final List<TemperatureEventListener> changeListeners = new ArrayList<>();

    private static final Logger LOG = LoggerFactory.getLogger(TemperatureHistory.class);

    // Defaault Constructor
    public TemperatureHistory() {
        minTempCache = new TemperaturePoint(Temperature.createFromCelsius(Float.MAX_VALUE), LocalDateTime.now());
        maxTempCache = new TemperaturePoint(Temperature.createFromCelsius(Float.MIN_VALUE), LocalDateTime.now());
    }

    public void add(final TemperaturePoint temperaturePoint) {
        try {
            checkTemperatureExtrema(temperaturePoint);
            this.temperatureHistory.add(temperaturePoint);
        } catch (NullPointerException npe) {
            throw new NullPointerException("The given temperature object is null");
        }
    }

    public void clear() {
        if (this.getCount() > 0) {
            // We need to clear out our temperature history.
            this.temperatureHistory.clear();

            // Reset our maxima temp caches as well.
            this.maxTempCache = null;
            this.minTempCache = null;
        }

    }

    public void checkTemperatureExtrema(final TemperaturePoint temperaturePoint) {

        if (temperaturePoint.compareTo(minTempCache) == -1) {

            minTempCache = TemperaturePoint.createFromTemperaturePoint(temperaturePoint);
            
            float newMinTemperature = temperaturePoint.getTemperature().getTemperatureCelsius();

            fireTemperatureEvent(new TemperatureEvent(this,
                    Temperature.createFromCelsius(newMinTemperature), TemperatureEventType.MIN));
            LOG.info("New Minimum Temperature: {}", newMinTemperature);
        }

        if (temperaturePoint.compareTo(maxTempCache) == 1) {
            maxTempCache = TemperaturePoint.createFromTemperaturePoint(temperaturePoint);

            float newMaxTemperature = temperaturePoint.getTemperature().getTemperatureCelsius();

            fireTemperatureEvent(new TemperatureEvent(this,
                    Temperature.createFromCelsius(newMaxTemperature), TemperatureEventType.MAX));
            LOG.info("New Maximum Temperature: {}", Temperature.createFromCelsius(newMaxTemperature));
        }

    }

    public int getCount() {
        return this.temperatureHistory.size();
    }

    public final List<TemperaturePoint> getTemperatureList() {

        List<TemperaturePoint> temperatureList = new ArrayList<>();

        try {
            Iterator<TemperaturePoint> iterator = temperatureHistory.iterator();

            while (iterator.hasNext()) {
                final TemperaturePoint temp = iterator.next();
                temperatureList.add(temp);
            }

        } catch (NullPointerException npe) {
            LOG.error("The tmeperature history is empty", npe.getMessage());
        }

        return temperatureList;
    }

    public TemperaturePoint getMaxTemperature() {

        if (this.getCount() == 0) {
            return null;
        }

        return TemperaturePoint.createFromTemperaturePoint(maxTempCache);
    }

    public TemperaturePoint getMinTemperature() {

        if (this.getCount() == 0) {
            return null;
        }

        return TemperaturePoint.createFromTemperaturePoint(minTempCache);
    }

    public TemperaturePoint getAverageTemperature() {

        if (this.getCount() == 0)
            return null;

        float average = 0;

        Iterator<TemperaturePoint> iterator = temperatureHistory.iterator();

        while (iterator.hasNext()) {
            final TemperaturePoint temp = iterator.next();

            average += temp.getTemperature().getTemperatureCelsius();
        }

        average /= this.getCount();

        return new TemperaturePoint(Temperature.createFromCelsius(average), LocalDateTime.now());
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
        return "Temperature History - Number of Temperature Points: " + this.getCount() + ", \nMax Temperature: "
                + this.getMaxTemperature() + " at timestamp: " + this.getMaxTemperature().getLDT() + ", \nMin Temperature: " + this.getMinTemperature()
                + " at timestamp: " + this.getMinTemperature().getLDT() + ", \nAverage Temperature: " + this.getAverageTemperature() + " at timestamp: " + this.getAverageTemperature().getLDT();
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
        return Objects.hash(this.getCount(), this.maxTempCache, this.minTempCache);
    }

    @Override
    public int compareTo(TemperatureHistory otherTemperatureDevelopment) {
        return Float.compare(this.getCount(), otherTemperatureDevelopment.getCount());
    }

}
