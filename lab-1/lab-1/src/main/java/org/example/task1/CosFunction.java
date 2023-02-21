package org.example.task1;

public class CosFunction {
    private static final double REPS = 0.000_000_000_001;

    private static double getFactorial(final int i) {
        double result = 1;
        int elem = i;
        while (elem > 0) {
            result *= elem;
            elem--;
        }

        return result;
    }

    private static double toNormalAngle(final double x) {
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

    /**
     * x in radians
     */
    public static double cos(final double x) {
        final double normalizedX = toNormalAngle(x);
        double result = 1;
        double r = 1;
        boolean sign = false;

        for (int i = 2; r > REPS; i += 2) {
            r = Math.pow(normalizedX, i) / getFactorial(i);
            if (sign) {
                result += r;
            } else {
                result -= r;
            }
            sign = !sign;
        }

        return result;
    }

}
