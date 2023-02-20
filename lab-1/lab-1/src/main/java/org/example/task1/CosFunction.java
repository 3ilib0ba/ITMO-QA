package org.example.task1;

public class CosFunction {
    private static final double rEps = 0.0000000000001;

    private static double getFactorial(int i) {
        double result = 1;
        while (i > 0) {
            result *= i;
            i--;
        }

        return result;
    }

    private static double toNormalAngle(double x) {
        if (x < 0) {
            x = -x;
        }
        if (x > 2 * Math.PI) {
            int count = (int) (x / (2 * Math.PI));
            x -= 2 * count * Math.PI;
        }
        return x;
    }

    /**
     * x in radians
     */
    public static double cos(double x) {
        x = toNormalAngle(x);
        double result = 1;
        double R = 1;
        boolean sign = false;

        for (int i = 2; R > rEps; i += 2) {
            R = Math.pow(x, i) / getFactorial(i);
            if (sign) {
                result += R;
            } else {
                result -= R;
            }
            sign = !sign;
        }

        return result;
    }

}
