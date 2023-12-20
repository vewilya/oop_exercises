package ch.hslu.oop.SW08.Temperature;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public final class TemperatureHistory implements Comparable<TemperatureHistory> {
    public static void main(String[] args) {
        final TemperatureHistory tD = new TemperatureHistory();

        // tD.add(new Temperature(10.543f));
        // tD.add(new Temperature(31.2342f));
        // tD.add(new Temperature(43.1123f));

        System.out.println(tD.getMaxTemperature());
        System.out.println(tD.getMinTemperature());

        System.out.println(tD.getCount());

        System.out.println("average temp: " + tD.getAverageTemperature());
        System.out.println(tD.toString());

        // tD.clear();

        // System.out.println(tD.getMinTemperature());

    }

    private final Collection<Temperature> temperatureHistory = new ArrayList<>();

    // Defualt Constructor
    public TemperatureHistory() {
    }

    public void add(final Temperature temperature) {
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
        // return Collections.max(this.temperatureHistory);
        return new Temperature(Collections.max(this.temperatureHistory).getTemperatureCelsius());
    }

    public Temperature getMinTemperature() {

        if (this.getCount() == 0) {
            return null;
        }

        return new Temperature(Collections.min(this.temperatureHistory).getTemperatureCelsius());
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

        return new Temperature(average);
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
