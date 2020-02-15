package org.mcknight.wicker.commons.lang;

import org.mcknight.wicker.commons.fs.WickerRecord;

public abstract class Expression {
    private Expression nextExpression;
    public abstract WickerRecord evaluate(WickerRecord record);
}
