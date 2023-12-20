package ch.hslu.oop.SW11.Temperature_writeToFile;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class StatsFileRnR {

    public StatsFileRnR() {
    }

    private static final Logger LOG = LoggerFactory.getLogger(StatsFileRnR.class);

    public final void printStatstFile(final String file, final TemperatureHistory tempHis) {

        String basePath = "src/main/java/ch/hslu/oop/SW11/Temperature_writeToFile/tmp/";
        String filePath = basePath + file;

        // List<TemperaturePoint> tList = tempHis.getTemperatureList();
        int numObjects = tempHis.getCount();

        if (!new File(basePath).exists())
            new File(basePath).mkdir();

        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(filePath))) {

            dos.writeInt(numObjects);

            for (final TemperaturePoint t : tempHis.getTemperatureList()) {
                dos.writeDouble(t.getTemperature().getTemperatureCelsius());
            }

            LOG.info("Wrote Temperature Stats to File!");
            dos.flush();
        } catch (IOException ioe) {
            LOG.error(ioe.getMessage(), ioe);
        }
    }

    public final void readStatsFile(String file) {
        String basePath = "src/main/java/ch/hslu/oop/SW11/Temperature_writeToFile/tmp/";
        String filePath = basePath + file;

        try (DataInputStream dis = new DataInputStream(new FileInputStream(filePath))) {
            int numObjects = dis.readInt();
            System.out.println(numObjects);

            for (int i = 0; i < numObjects; i++) {
                double value = dis.readDouble();
                System.out.println(value);
            }

        } catch (IOException ioe) {
            LOG.error(ioe.getMessage(), ioe);
        }

    }

    public final void deleteStatsFile() {
        File f = new File("src/main/java/ch/hslu/oop/SW11/Temperature_writeToFile/tmp/temperatureStats.bin");

        if (f.exists())
            f.delete();
    }
}
