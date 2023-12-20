package ch.hslu.oop.SW09.Test;

import java.util.Scanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.hslu.oop.SW09.Temperature.Temperature;

public class Test {

    // Logger
    private static final Logger LOG = LoggerFactory.getLogger(Test.class);

    public static void main(String[] args) {

        String input;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Bitte Temperatur eingeben (oder 'exit' zum Beenden): ");
            input = scanner.next();

            if ("exit".equals(input))
                break;

            try {
                float value = Float.valueOf(input);
                Temperature temp = Temperature.createFromCelsius(value);
                LOG.info("Given temperature value is {}", temp.getTemperatureCelsius());
            } catch (NumberFormatException nfe) {
                LOG.error("Please enter a floating point value! Message: {}", nfe.getMessage(), nfe);
            } catch (IllegalArgumentException iae) {
                LOG.error("Please respect Low Temperature Limit", iae.toString());
            }
        } while (!"exit".equals(input));

        System.out.println("Programm beendet.");

        // Avoid Memory Leakage and close scanner object!
        scanner.close();
    }

}