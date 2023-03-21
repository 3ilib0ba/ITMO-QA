package test.java.trigs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import trigs.MocksTrigs;

public class SecTest {
    private final Double EPS = 0.000_000_001;

    private static MocksTrigs mocksTrigs = new MocksTrigs();

    private main.java.trigs.Sec sec;

    @BeforeAll
    static void init() {
        mocksTrigs.mockAll();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/csv_in/sec_csv")
    void testCos(double value, double expected) {
        sec = new main.java.trigs.Sec(mocksTrigs.cosMock);
        Assertions.assertEquals(
                expected, sec.sec(value, EPS), EPS);
    }
}
