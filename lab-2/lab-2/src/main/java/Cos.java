package main.java;

public class Cos {
    private static double toNormalAngleCos(final double x) {
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

    public static double cos(double x, double exp) {
        double sin_result = Sin.sin(x, exp);
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
}
