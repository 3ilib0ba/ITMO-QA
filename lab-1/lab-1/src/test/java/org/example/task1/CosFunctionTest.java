package org.example.task1;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CosFunctionTest {
    private final double epsilon = 0.000001;

    @ParameterizedTest
    @ValueSource(doubles = {0.0, Math.PI / 2, Math.PI, 3 * Math.PI / 2})
    public void checkNormalValues(double value) {
        Assertions.assertTrue(Math.cos(value) - CosFunction.cos(value) < epsilon);
        Assertions.assertTrue(Math.cos(-value) - CosFunction.cos(value) < epsilon);
    }

    @ParameterizedTest
    @ValueSource(doubles = {2 * Math.PI, 5 * Math.PI / 2, 3 * Math.PI, 7 * Math.PI / 2})
    public void checkNotNormalValues(double value) {
        Assertions.assertTrue(Math.cos(value) - CosFunction.cos(value) < epsilon);
        Assertions.assertTrue(Math.cos(-value) - CosFunction.cos(-value) < epsilon);
    }
}
