package main.java;

import main.java.logs.Ln;
import main.java.logs.Log;
import main.java.trigs.Cos;
import main.java.trigs.Sec;
import main.java.trigs.Sin;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

public class MyFunction {
    private final Double EPS = 0.000_000_001;
    private main.java.trigs.Sec sec;
    private main.java.logs.Ln ln;
    private main.java.logs.Log log;

    public MyFunction(Sec sec, Ln ln, Log log) {
        this.sec = sec;
        this.ln = ln;
        this.log = log;
    }

    public double function_solve(double x, double eps) {
        double result;
        if (x <= 0) {
            result = sec.sec(x, eps) - sec.sec(x, eps);
        } else {
            result =
                    ((
                            (Math.pow(log.log(3, x, eps), 3) / log.log(3, x, eps)) -
                                    (log.log(2, x, eps) * (ln.ln(x, eps) - log.log(5, x, eps)))
                    ) *
                            log.log(5, x, eps)
                    ) +
                            log.log(10, x, eps);
        }
        return result;
    }


    public String formatToCSV(double x, double limit, double step, double eps) {
        StringBuilder result = new StringBuilder();
        while (x <= limit) {
            result.append(x).append(",").append(function_solve(x, eps)).append("\n");
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
        Sec sec = new Sec(new Cos(new Sin()));
        Ln ln = new Ln();
        Log log = new Log(ln);
        MyFunction my = new MyFunction(sec, ln, log);
        my.writeToCSV(
                my.formatToCSV(-1, 40, 1, my.EPS),
                new FileWriter("src/main/resources/csv_out/func_csv")
        );
    }
}
