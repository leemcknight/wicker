package org.mcknight.wicker.commons.fs;

import org.mcknight.wicker.commons.lang.Expression;

import java.net.URI;
import java.util.function.Function;

public class WickerRecordSet {
    private Schema schema;
    private Expression expression;
    private WickerFile file;
    private WickerFileReader reader;

    public WickerRecordSet() {
        reader = 
    }

    public void load(URI uri) {

    }

    public void load(String path) {

    }

    public WickerRecord next() {
        return null;
    }

    public WickerRecord current() {
        return null;
    }

    public long count() { return 0; }

    public WickerRecordSet filter(String filterExpression) {
        return this;
    }

    public WickerRecordSet orderBy(String column) {
        return this;
    }

    public WickerRecordSet join(WickerRecordSet joinedRecordSet, String joinExpression) {
        return this;
    }

    public WickerRecordSet groupBy(String column) {
        return this;
    }

    public WickerRecordSet map(Function<WickerRecord, WickerRecord> func) {
        return this;
    }

    public WickerRecordSet reduce(Function<WickerRecord, WickerRecord> func) {
        return this;
    }
}
