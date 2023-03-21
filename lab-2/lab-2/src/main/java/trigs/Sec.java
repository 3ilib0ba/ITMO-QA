package main.java.trigs;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

public class Sec {
    private final Double EPS = 0.000_000_001;
    private main.java.trigs.Cos cos;

    public Sec(main.java.trigs.Cos cos) {
        this.cos = cos;
    }
    public double sec(double x, double eps) {
        double cos_result = cos.cos(x, eps);
        if (Math.abs(cos_result) < eps)
            return Double.NaN;
        return 1.0d / cos_result;
    }

    public String formatToCSV(double x, double limit, double step, double eps) {
        StringBuilder result = new StringBuilder();
        while (x <= limit) {
            result.append(x).append(",").append(sec(x, eps)).append("\n");
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
        Sec sec = new Sec(new main.java.trigs.Cos(new main.java.trigs.Sin()));
        sec.writeToCSV(
                sec.formatToCSV(-10 * Math.PI, 10 * Math.PI, Math.PI / 6, sec.EPS),
                new FileWriter("src/main/resources/csv_out/sec_csv")
        );
    }
}
