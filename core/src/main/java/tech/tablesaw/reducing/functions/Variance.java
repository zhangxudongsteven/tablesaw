package tech.tablesaw.reducing.functions;

import static tech.tablesaw.reducing.NumericReduceUtils.variance;

import tech.tablesaw.api.Table;
import tech.tablesaw.reducing.NumericReduceFunction;

/**
 *
 */
public class Variance extends SummaryFunction {

    public Variance(Table original, String summarizedColumnName) {
        super(original, summarizedColumnName);
    }

    @Override
    public NumericReduceFunction function() {
        return variance;
    }
}
