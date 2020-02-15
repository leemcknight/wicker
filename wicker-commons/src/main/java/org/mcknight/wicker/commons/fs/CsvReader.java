package org.mcknight.wicker.commons.fs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

/**
 * CSV Reader/Parser for Wicker.
 * Follows: https://www.ietf.org/rfc/rfc4180.txt
 */
public class CsvReader extends WickerFileReader {
    BufferedReader reader;
    private boolean headerLine;
    private List<String> columns;

    public CsvReader() {

    }

    public CsvReader(boolean headerLine) {
        this.headerLine = headerLine;
    }
    

    @Override
    public void open(String fileName) {
        File file = new File(fileName);
        reader = new BufferedReader(new FileReader(file));
        if(headerLine) {
            
        }
    }

    @Override
    public Stream<WickerRecord> stream() {        
        return reader.lines().map(line -> buildRecord(line));
    }

    private WickerRecord buildRecord(String line) {
        WickerRecord record = new WickerRecord();
        StringBuilder fieldBuilder = new StringBuilder();
        line.chars().forEach(ch -> {
            
            fieldBuilder.append(ch);
            
        }); 
        return record;
    }
}
