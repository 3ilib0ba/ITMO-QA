package main.java.trigs;

import java.io.*;

public class Sin {
    private final Double EPS = 0.000_000_001;
    private double getFactorial(final int i) {
        double result = 1;
        int elem = i;
        while (elem > 0) {
            result *= elem;
            elem--;
        }

        return result;
    }

    private double toNormalAngleSin(final double x) {
        double normalX = x;
        if (normalX > 2 * Math.PI) {
            final int count = (int) (normalX / (2 * Math.PI));
            normalX -= 2 * count * Math.PI;
        }
        if (normalX < -2 * Math.PI) {
            final int count = (int) (-normalX / (2 * Math.PI));
            normalX += 2 * count * Math.PI;
        }
        return normalX;
    }

    /**
     * x in radians
     */
    public double sin(double x, double eps) {
        final double normalizedX = toNormalAngleSin(x);
        double result = 0;
        double r = 1;
        boolean sign = true;

        for (int i = 1; Math.abs(r) > eps; i += 2) {
            r = Math.abs(Math.pow(normalizedX, i)) / getFactorial(i);
            if (sign)
                result += r;
            else
                result -= r;
            sign = !sign;
        }

        if (Math.abs(result) < eps)
            return 0; // greater accuracy is required
        return result;
    }

    public String formatToCSV(double x, double limit, double step, double eps) {
        StringBuilder result = new StringBuilder();
        while (x <= limit) {
            result.append(x).append(",").append(sin(x, eps)).append("\n");
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
        Sin sin = new Sin();
        sin.writeToCSV(
                sin.formatToCSV(-10 * Math.PI, 10 * Math.PI, Math.PI / 6, sin.EPS),
                new FileWriter("src/main/resources/csv_out/sin_csv")
        );
    }
}
