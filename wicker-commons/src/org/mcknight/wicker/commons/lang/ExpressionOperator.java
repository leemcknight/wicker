package org.mcknight.wicker.commons.lang;

import org.mcknight.wicker.commons.fs.WickerRecord;

public abstract class ExpressionOperator {
    private Expression rightExpression;
    private Expression leftExpression;

    public ExpressionOperator(Expression rightExpression, Expression leftExpression) {
        this.rightExpression = rightExpression;
        this.leftExpression = leftExpression;
    }

    public WickerRecord evaluate(WickerRecord record) {
        WickerRecord rightRecord = rightExpression.evaluate(record);
        WickerRecord leftRecord = leftExpression.evaluate(record);
        return evaluateCore(record, rightRecord, leftRecord);
    }

    protected abstract WickerRecord evaluateCore(WickerRecord inputRecord, WickerRecord rightResult, WickerRecord leftResult);
}
