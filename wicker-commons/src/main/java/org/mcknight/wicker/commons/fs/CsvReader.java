package org.mcknight.wicker.commons.fs;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.FileReader;
import java.util.ArrayList;
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
    public void open(String fileName) throws IOException {
        File file = new File(fileName);
        reader = new BufferedReader(new FileReader(file));
        if(headerLine) {
            String header = reader.readLine();
            columns = buildHeaderLineColumns(header);
        }
    }

    @Override
    public Stream<WickerRecord> stream() {        
        return reader.lines().map(line -> buildRecord(line));
    }

    private WickerRecord buildRecord(String line) {
        WickerRecord record = new WickerRecord();
        StringBuilder fieldBuilder = new StringBuilder();
        boolean insideQuotes = false;
        boolean escaped = false;
        int columnIndex = 0;
        
        for(int i = 0; i < line.length(); i++) {
            char ch = line.charAt(i);
            switch(ch) {
                case ',':
                    if(insideQuotes) {
                        fieldBuilder.append(ch);
                    } else {
                        String columnName = "";
                        if(columns == null || columns.isEmpty()) {
                            columnName = "column_" + columnIndex++;
                        } else {
                            columnName = columns.get(columnIndex++);
                        }
                        record.add(columnName, fieldBuilder.toString());
                        fieldBuilder = new StringBuilder();
                    }
                    break;
                default:
                    fieldBuilder.append(ch);
                    break;
            }
        }

        return record;
    }

    private List<String> buildHeaderLineColumns(String header) {
        String[] parts = header.split(",");
        List<String> cols = new ArrayList<>();
        for(String part : parts) {
            cols.add(part);
        }

        return cols;
    }
}
