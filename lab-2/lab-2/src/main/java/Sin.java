package main.java;

public class Sin {
    private static double getFactorial(final int i) {
        double result = 1;
        int elem = i;
        while (elem > 0) {
            result *= elem;
            elem--;
        }

        return result;
    }

    private static double toNormalAngleSin(final double x) {
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
    public static double sin(double x, double eps) {
        final double normalizedX = toNormalAngleSin(x);
        double result = 1;
        double r = 1;
        boolean sign = false;

        for (int i = 1; r > eps; i += 2) {
            r = Math.pow(normalizedX, i) / getFactorial(i);
            if (sign) {
                result += r;
            } else {
                result -= r;
            }
            sign = !sign;
        }

        if (Math.abs(result) < eps)
            return 0; // greater accuracy is required
        return result;
    }
}
