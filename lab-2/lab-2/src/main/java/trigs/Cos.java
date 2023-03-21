package main.java.trigs;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

public class Cos {
    private final Double EPS = 0.000_000_001;
    private main.java.trigs.Sin sin;

    public Cos(main.java.trigs.Sin sin) {
        this.sin = sin;
    }
    private double toNormalAngleCos(final double x) {
        double normalX = x;
        if (normalX < 0) {
            normalX = -normalX;
        }
        if (normalX > 2 * Math.PI) {
            final int count = (int) (normalX / (2 * Math.PI));
            normalX -= 2 * count * Math.PI;
        }
        return normalX;
    }

    public double cos(double x, double exp) {
        double sin_result = sin.sin(x, exp);
        double cos_result = 0;

        x = toNormalAngleCos(x);
        if (x >= Math.PI) {
            cos_result = -1 * Math.sqrt(1 - Math.pow(sin_result, 2));
        } else {
            cos_result =  1 * Math.sqrt(1 - Math.pow(sin_result, 2));
        }

        if (Math.abs(cos_result) < exp)
            return 0; // greater accuracy is required
        return cos_result;
    }

    public String formatToCSV(double x, double limit, double step, double eps) {
        StringBuilder result = new StringBuilder();
        while (x <= limit) {
            result.append(x).append(",").append(cos(x, eps)).append("\n");
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
        Cos cos = new Cos(new main.java.trigs.Sin());
        cos.writeToCSV(
                cos.formatToCSV(-10 * Math.PI, 10 * Math.PI, Math.PI / 6, cos.EPS),
                new FileWriter("src/main/resources/csv_out/cos_csv")
        );
    }
}
