package ch.hslu.oop.SW09.Temperature;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public final class TemperatureHistory implements Comparable<TemperatureHistory> {

    private final Collection<Temperature> temperatureHistory = new ArrayList<>();

    // Defualt Constructor
    public TemperatureHistory() {
    }

    public void add(final Temperature temperature) {
        if (temperature == null)
            return;
        else
            this.temperatureHistory.add(temperature);
    }

    public void clear() {
        if (this.getCount() > 0)
            this.temperatureHistory.clear();
    }

    public int getCount() {
        return this.temperatureHistory.size();
    }

    public Temperature getMaxTemperature() {

        if (this.getCount() == 0) {
            return null;
        }

        // Ruft die compareTo()-methode auf
        return Temperature.createFromCelsius(Collections.max(this.temperatureHistory).getTemperatureCelsius());
    }

    public Temperature getMinTemperature() {

        if (this.getCount() == 0) {
            return null;
        }

        return Temperature.createFromCelsius(Collections.min(this.temperatureHistory).getTemperatureCelsius());
    }

    public Temperature getAverageTemperature() {

        float average = 0;

        if (this.getCount() > 0) {
            Iterator<Temperature> iterator = temperatureHistory.iterator();

            while (iterator.hasNext()) {
                final Temperature temp = iterator.next();

                average += temp.getTemperatureCelsius();
            }

            average /= this.getCount();
        }

        return Temperature.createFromCelsius(average);
    }

    @Override
    public String toString() {
        return "Temperature Development - Number of Temperatures: " + this.getCount() + ", Max Temperature: "
                + this.getMaxTemperature() + ", Min Temperature: " + this.getMinTemperature();
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
