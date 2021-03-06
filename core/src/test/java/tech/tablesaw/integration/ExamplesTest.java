package tech.tablesaw.integration;

import static tech.tablesaw.api.ColumnType.*;

import tech.tablesaw.api.ColumnType;
import tech.tablesaw.api.QueryHelper;
import tech.tablesaw.api.Table;
import tech.tablesaw.io.csv.CsvReadOptions;
import tech.tablesaw.io.csv.CsvWriter;

/**
 * Some example code using the API
 */
public class ExamplesTest {

    public static void main(String[] args) throws Exception {

        out("");
        out("Some Examples: ");

        // Read the CSV file
        ColumnType[] types = {INTEGER, CATEGORY, CATEGORY, FLOAT, FLOAT};
        Table table = Table.read().csv(CsvReadOptions.builder("../data/bus_stop_test.csv").columnTypes(types));

        // Look at the column names
        out(table.columnNames());

        // Peak at the data
        out(table.first(5));

        // Remove the description column
        table.removeColumns("stop_desc");

        // Check the column names to see that it's gone
        out(table.columnNames());

        // Take a look at some data
        out("In 'examples. Printing first(5)");
        out(table.first(5));

        // Lets take a look at the latitude and longitude columns
        // out(table.realColumn("stop_lat").rowSummary().out());
        out(table.floatColumn("stop_lat").summary());

        // Now lets fill a column based on data in the existing columns

        // Apply the map function and fill the resulting column to the original table

        // Lets filtering out some of the rows. We're only interested in records with IDs between 524-624

        Table filtered = table.selectWhere(QueryHelper.column("stop_id").isBetween(524, 624));
        out(filtered.first(5));

        // Write out the new CSV file
        CsvWriter.write(filtered, "../data/filtered_bus_stops.csv");
    }

    private static void out(Object o) {
        System.out.println(o);
    }
}
