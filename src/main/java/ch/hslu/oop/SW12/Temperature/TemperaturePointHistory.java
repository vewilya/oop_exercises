package ch.hslu.oop.SW12.Temperature;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class TemperaturePointHistory implements Comparable<TemperaturePointHistory> {

    // ------------------------------ Attributes ---------------------------- //
    private final Collection<TemperaturePoint> temperaturePointHistory = new ArrayList<>();

    private TemperaturePoint minTempCache;
    private TemperaturePoint maxTempCache;

    private final List<TemperatureEventListener> changeListeners = new ArrayList<>();

    private static final Logger LOG = LoggerFactory.getLogger(TemperaturePointHistory.class);

    final Comparator<TemperaturePoint> tempComp = (tp1, tp2) -> tp1.compareTo(tp2);

    // Defaault Constructor
    public TemperaturePointHistory() {
        minTempCache = new TemperaturePoint(Temperature.createFromCelsius(Float.MAX_VALUE), LocalDateTime.now());
        maxTempCache = new TemperaturePoint(Temperature.createFromCelsius(Float.MIN_VALUE), LocalDateTime.now());
    }

    public void add(final TemperaturePoint temperaturePoint) {
        try {
            this.checkTemperatureExtrema(temperaturePoint);
            this.temperaturePointHistory.add(temperaturePoint);
        } catch (NullPointerException npe) {
            throw new NullPointerException("The given temperature object is null");
        }
    }

    public void clear() {
        try {
            // We need to clear out our temperature history.
            this.temperaturePointHistory.clear();

            // Reset our maxima temp caches as well.
            this.maxTempCache = null;
            this.minTempCache = null;

        } catch (NullPointerException npe) {
            LOG.error(npe.getMessage(), npe);
        }
    }

    public void checkTemperatureExtrema(final TemperaturePoint temperaturePoint) {

        try {
            float tpCelsius = temperaturePoint.getTemperature().getTemperatureCelsius();

            if (maxTempCache.compareTo(temperaturePoint) == -1) {

                maxTempCache = new TemperaturePoint(temperaturePoint.getTemperature(), temperaturePoint.getLDT());

                LOG.info("New Maximum Temperature: {}", Temperature.createFromCelsius(tpCelsius));

                fireTemperatureEvent(new TemperatureEvent(this,
                        Temperature.createFromCelsius(tpCelsius), TemperatureEventType.MAX));
            } else if (minTempCache.compareTo(temperaturePoint) == 1) {
                minTempCache = new TemperaturePoint(temperaturePoint.getTemperature(), temperaturePoint.getLDT());

                LOG.info("New Minimum Temperature: {}", Temperature.createFromCelsius(tpCelsius));

                fireTemperatureEvent(new TemperatureEvent(this,
                        Temperature.createFromCelsius(tpCelsius), TemperatureEventType.MIN));
            }
        } catch (NullPointerException npe) {
            LOG.error("No valid TemperaturePoint Object!", npe.getMessage());
        }
    }

    public int getCount() {
        return (int) temperaturePointHistory.stream().count();
    }

    public final List<TemperaturePoint> getTemperatureList() {

        List<TemperaturePoint> tpCollection = new ArrayList<TemperaturePoint>();

        try {
            tpCollection = (List<TemperaturePoint>) this.temperaturePointHistory;

        } catch (NullPointerException npe) {
            LOG.error("The tmeperature history is empty", npe.getMessage());
        }

        return tpCollection;
    }

    public final List<TemperaturePoint> getPositiveTemperatures() {

        return this.temperaturePointHistory.stream()
                .filter(t -> t.isTemperaturePointPositve(t)).toList();

    }

    public TemperaturePoint getMaxTemperature() {
        double maxTemp = Double.MIN_VALUE;

        try {
            maxTemp = temperaturePointHistory.stream()
                    .mapToDouble(t -> t.getTemperature().getTemperatureCelsius())
                    .max().getAsDouble();
        } catch (NullPointerException npe) {
            LOG.error("The TemperaturePoint history is empty", npe.getMessage());
        }

        return new TemperaturePoint(Temperature.createFromCelsius((float) maxTemp), LocalDateTime.now());
    }

    public TemperaturePoint getMinTemperature() {

        float minTemp = Float.MAX_VALUE;

        try {
            minTemp = temperaturePointHistory.stream().map(t -> t.getTemperature())
                    .map(temp -> temp.getTemperatureCelsius()).min(Comparator.naturalOrder()).get();
        } catch (NullPointerException npe) {
            LOG.error("The TemperaturePoint history is empty", npe.getMessage());
        }

        return new TemperaturePoint(Temperature.createFromCelsius(minTemp), LocalDateTime.now());
    }

    public TemperaturePoint getAverageTemperature() {

        double average = Double.MIN_VALUE;

        try {
            average = temperaturePointHistory.stream().mapToDouble(t -> t.getTemperature().getTemperatureCelsius())
                    .average().getAsDouble();

        } catch (NullPointerException npe) {
            LOG.error("The TemperaturePoint history is empty", npe.getMessage());
        }

        return new TemperaturePoint(Temperature.createFromCelsius((float) average), LocalDateTime.now());
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
                + this.getMaxTemperature() + " at timestamp: " + this.getMaxTemperature().getLDT()
                + ", \nMin Temperature: " + this.getMinTemperature()
                + " at timestamp: " + this.getMinTemperature().getLDT() + ", \nAverage Temperature: "
                + this.getAverageTemperature() + " at timestamp: " + this.getAverageTemperature().getLDT();
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
    public int compareTo(TemperaturePointHistory otherTemperatureDevelopment) {
        return Integer.compare(this.getCount(), otherTemperatureDevelopment.getCount());
    }

}
