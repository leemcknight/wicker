package org.mcknight.wicker.commons.lang;

import org.mcknight.wicker.commons.fs.WickerRecord;

public class FilterExpression extends Expression {
    private String expression;
    private Object filterValue;

    public FilterExpression isEqualTo(Object o) {
        return null;
    }

    @Override
    public WickerRecord evaluate(WickerRecord record) {
        return null;
    }

}
