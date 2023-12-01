package ch.hslu.oop.SW11.csvTemperatureRead;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StringMangler {
    
    public StringMangler() {}

    public String getSplitPart(String string, String split, int arrayIndex) {
        
        String[] values = string.split(split);
        String part = values[arrayIndex].trim(); // Third value (index 2), trim to remove whitespace

        return part;
    }

    public LocalDateTime formatLTD(final String ltdAsString) {
        LocalDateTime timestamp = LocalDateTime.parse(ltdAsString, DateTimeFormatter.ofPattern("\"yyyy/MM/dd HH:mm:ss\""));  
        return timestamp;
    }

}
