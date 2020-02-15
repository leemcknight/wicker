package org.mcknight.wicker.commons.fs;

public class ReaderFactory {

    private String type;
    private Schema schema;
    private boolean csvHeader;

    public ReaderFactory csv(boolean header) {
        type = "csv";
        this.csvHeader = header;
        return this;
    }

    public ReaderFactory json() {
        type = "json";
        return this;
    }

    public ReaderFactory parquet() {
        type = "parquet";
        return this;
    }

    public ReaderFactory xml() {
        type = "xml";
        return this;
    }

    public ReaderFactory withSchema(Schema schema) {
        this.schema = schema;
        return this;
    }

    public WickerFileReader build() {
        WickerFileReader reader = null;
        switch(type) {
            case "json":
                break;
            case "csv":
                reader = new CsvReader(csvHeader);
                break;
            default:
                break;
        }
        
        reader.setSchema(schema);
        return reader;
    }

}