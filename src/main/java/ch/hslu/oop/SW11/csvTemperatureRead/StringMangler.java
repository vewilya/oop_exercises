package ch.hslu.oop.SW11.csvTemperatureRead;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Helper class for string manipulation
 */
public class StringMangler {

    public StringMangler() {
    }

    private static final Logger LOG = LoggerFactory.getLogger(StringMangler.class);

    public String getSplitPart(String string, String split, int arrayIndex) {

        String part = "empty";
        String[] values = string.split(split);

        try {
            part = values[arrayIndex].trim();

        } catch (ArrayIndexOutOfBoundsException aioob) {
            LOG.error(aioob.getMessage(), aioob);
        }

        return part;

    }

    public LocalDateTime formatLTD(final String ltdAsString) {
        LocalDateTime timestamp = LocalDateTime.parse(ltdAsString,
                DateTimeFormatter.ofPattern("\"yyyy/MM/dd HH:mm:ss\""));

        return timestamp;
    }

}
