package main.java.logs;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

public class Log {
    private final Double EPS = 0.000_000_001;
    private main.java.logs.Ln ln;

    public Log(main.java.logs.Ln ln) {
        this.ln = ln;
    }

    public double log(double a, double b, double esp) {
        if (a == (double) 1) {
            return Double.NaN;
        }
        return ln.ln(b, esp) / ln.ln(a, esp);
    }

    public String formatToCSV(double base, double x, double limit, double step, double eps) {
        StringBuilder result = new StringBuilder();
        while (x <= limit) {
            result.append(base).append(",").append(x).append(",").append(log(base, x, eps)).append("\n");
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
        Log log = new Log(new main.java.logs.Ln());
        log.writeToCSV(
                log.formatToCSV(3, 0, 120, 1, log.EPS),
                new FileWriter("src/main/resources/csv_out/log3_csv")
        );
        log.writeToCSV(
                log.formatToCSV(10, 0, 120, 1, log.EPS),
                new FileWriter("src/main/resources/csv_out/log10_csv")
        );
        log.writeToCSV(
                log.formatToCSV(2, 0, 120, 1, log.EPS),
                new FileWriter("src/main/resources/csv_out/log2_csv")
        );
        log.writeToCSV(
                log.formatToCSV(5, 0, 120, 1, log.EPS),
                new FileWriter("src/main/resources/csv_out/log5_csv")
        );
    }

    public main.java.logs.Ln getLn() {
        return ln;
    }
}
