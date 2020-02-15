package org.mcknight.wicker.commons.fs;

import java.io.IOException;
import java.util.stream.*;

public abstract class WickerFileReader {

    private Schema schema;

    public abstract void open(String fileName) throws IOException;

    public abstract Stream<WickerRecord> stream();

    public Schema getSchema() {
        return schema;
    }

    public void setSchema(Schema schema) {
        this.schema = schema;
    }
    
}