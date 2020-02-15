package org.mcknight.wicker.commons.lang;

import org.mcknight.wicker.commons.fs.WickerRecord;

public class AndOperator extends ExpressionOperator {

    public AndOperator(Expression rightExpression, Expression leftExpression) {
        super(rightExpression, leftExpression);
    }

    @Override
    protected WickerRecord evaluateCore(WickerRecord inputRecord, WickerRecord rightResult, WickerRecord leftResult) {
        if(rightResult != null && leftResult != null) {
            return inputRecord;
        }

        return null;
    }
}
