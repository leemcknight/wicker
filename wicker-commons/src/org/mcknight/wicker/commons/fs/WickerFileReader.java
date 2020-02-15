package org.mcknight.wicker.commons.fs;

import java.io.IOException;

public abstract class WickerFileReader {

    private Schema schema;

    public abstract WickerRecordSet open(String fileName);

    public abstract WickerRecord next() throws IOException;

    public Schema getSchema() {
        return schema;
    }

    public void setSchema(Schema schema) {
        this.schema = schema;
    }
    
}