package org.mcknight.wicker.commons.fs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.Test;

public class WickerRecordSetTest {

    @Test
    public void testFilter() {
        WickerRecordSet<Person> rs = new WickerRecordSet<>(Person.class);
        try {
            rs.loadCsv("src/test/resources/sample.csv");
            Person p = rs.filter(person -> person.getFirstName().equals("Lee")).findFirst().get();
            assertNotNull(p);
            assertEquals("McKnight", p.getLastName());
            assertEquals("lee_mcknight@hotmail.com", p.getEmail());
        } catch(Exception e) {
            fail(e.getMessage());
        } finally {
            rs.close();
        }
    }
}