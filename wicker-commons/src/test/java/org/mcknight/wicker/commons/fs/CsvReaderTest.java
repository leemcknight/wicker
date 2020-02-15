package org.mcknight.wicker.commons.fs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

public class CsvReaderTest {
    
    @Test
    public void readFileTestHeader() {
        try {
            CsvReader reader = new CsvReader(true);
            reader.open("src/test/resources/sample.csv");
            assertEquals(2, reader.stream().count());
        } catch(Exception e) {
            fail(e.getMessage());
        }
    }
}