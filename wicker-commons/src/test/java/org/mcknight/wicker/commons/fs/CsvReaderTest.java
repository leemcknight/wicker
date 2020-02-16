package org.mcknight.wicker.commons.fs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

import java.util.Optional;

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

    @Test
    public void checkWickerRecordContents() {
        try {
            CsvReader reader = new CsvReader(true);
            reader.open("src/test/resources/sample.csv");
            Optional<WickerRecord> rec = reader.stream().findFirst();
            assertFalse("rec was empty!", rec.isEmpty());
            assertEquals("Lee", rec.get().getString("firstName"));
        } catch(Exception e) {
            fail(e.getMessage());
        }
    }
}