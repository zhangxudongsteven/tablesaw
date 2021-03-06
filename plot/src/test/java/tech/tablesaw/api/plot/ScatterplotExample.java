package tech.tablesaw.api.plot;

import tech.tablesaw.api.NumericColumn;
import tech.tablesaw.api.Table;
import tech.tablesaw.api.plot.Scatter;

/**
 *
 */
public class ScatterplotExample {

    public static void main(String[] args) throws Exception {
        Table baseball = Table.read().csv("../data/baseball.csv");
        NumericColumn x = baseball.nCol("BA");
        NumericColumn y = baseball.nCol("W");
        Scatter.show(x, y);

        Scatter.show("Regular season wins by year",
                baseball.numericColumn("W"),
                baseball.numericColumn("Year"),
                baseball.splitOn(baseball.column("Playoffs")));
    }
}