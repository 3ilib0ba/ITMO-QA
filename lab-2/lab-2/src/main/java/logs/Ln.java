package main.java.logs;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

public class Ln {
    private final Double EPS = 0.000_000_001;
    public double ln(double x, double eps) {
        if (Double.isNaN(x) || x < (double) 0) {
            return Double.NaN;
        } else if (x == Double.POSITIVE_INFINITY) {
            return Double.POSITIVE_INFINITY;
        } else if (x == 0.0) {
            return Double.NEGATIVE_INFINITY;
        }

        double constant = ((x - 1) * (x - 1)) / ((x + 1) * (x + 1));

        double sum = 0;
        double currentValue = (x - 1) / (x + 1);
        int i = 1;
        while (Math.abs(currentValue) > eps) {
            sum += currentValue;
            currentValue = (2 * i - 1) * currentValue * constant / (2 * i + 1);
            i++;
        }
        sum *= 2;
        return sum;
    }


    public String formatToCSV(double x, double limit, double step, double eps) {
        StringBuilder result = new StringBuilder();
        while (x <= limit) {
            result.append(x).append(",").append(ln(x, eps)).append("\n");
            x += step;
        }
        return result.toString();
    }

    public void writeToCSV(String toOut, Writer out) {
        try (PrintWriter printer = new PrintWriter(out)) {
            printer.print(toOut);
        }
    }

    public static void main(String[] args) throws IOException {
        Ln ln = new Ln();
        ln.writeToCSV(
                ln.formatToCSV(0, 120, 1, ln.EPS),
                new FileWriter("src/main/resources/csv_out/ln_csv")
        );
    }
}
