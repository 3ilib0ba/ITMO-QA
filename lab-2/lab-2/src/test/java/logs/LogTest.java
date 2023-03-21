package test.java.logs;

import logs.MockLogs;
import main.java.logs.Log;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class LogTest {
    private final Double EPS = 0.000_000_001;
    private static MockLogs mocksLogs = new MockLogs();

    private main.java.logs.Log log;

    @BeforeAll
    static void init() {
        mocksLogs.mockAll();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/csv_in/log2_csv")
    void testLog2(double base, double value, double expected) {
        log = new Log(mocksLogs.lnMock);
        Assertions.assertEquals(
                expected, log.log(base, value, EPS), EPS);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/csv_in/log3_csv")
    void testLog3(double base, double value, double expected) {
        log = new Log(mocksLogs.lnMock);
        Assertions.assertEquals(
                expected, log.log(base, value, EPS), EPS);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/csv_in/log5_csv")
    void testLog5(double base, double value, double expected) {
        log = new Log(mocksLogs.lnMock);
        Assertions.assertEquals(
                expected, log.log(base, value, EPS), EPS);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/csv_in/log10_csv")
    void testLog10(double base, double value, double expected) {
        log = new Log(mocksLogs.lnMock);
        Assertions.assertEquals(
                expected, log.log(base, value, EPS), EPS);
    }
}
