package org.example.task1;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CosFunctionTest {
    double epsilon = 0.000001;

    @ParameterizedTest
    @ValueSource(doubles = {0.0, Math.PI, Math.PI / 2, 3 * Math.PI / 2})
    public void checkValues(double value) {
        Assertions.assertTrue(Math.cos(value) - CosFunction.cos(value) < epsilon);
    }
}
