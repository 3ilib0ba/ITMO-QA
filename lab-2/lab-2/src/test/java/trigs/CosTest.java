package test.java.trigs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import trigs.MocksTrigs;

public class CosTest {
    private final Double EPS = 0.000_000_001;

    private static MocksTrigs mocksTrigs = new MocksTrigs();

    private main.java.trigs.Cos cos;

    @BeforeAll
    static void init() {
        mocksTrigs.mockAll();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/csv_in/cos_csv")
    void testCos(double value, double expected) {
        cos = new main.java.trigs.Cos(mocksTrigs.sinMock);
        Assertions.assertEquals(
                expected, cos.cos(value, EPS), EPS);
    }
}
