package main.java;

public class Sec {
    public static double sec(double x, double eps) {
        double cos_result = Cos.cos(x, eps);
        if (cos_result == 0)
            return Double.NaN;
        return 1.0d / cos_result;
    }
}
