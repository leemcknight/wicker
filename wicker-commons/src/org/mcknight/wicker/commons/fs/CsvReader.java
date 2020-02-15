package org.mcknight.wicker.commons.fs;

import java.io.BufferedReader;

public class CsvReader extends WickerFileReader {
    BufferedReader reader;
    private boolean headerLine;

    public CsvReader() {

    }

    public CsvReader(boolean headerLine) {
        this.headerLine = headerLine;
    }
    

    @Override
    public void open(String fileName) {
        
    }

    @Override
    public WickerRecord next() {
        String line;
        WickerRecord record;
        
        while((line = reader.readLine()) != null) {
            
        }       
    }
}
