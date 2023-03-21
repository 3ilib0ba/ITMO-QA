package test.java;

import logs.MockLogs;
import main.java.MyFunction;
import main.java.logs.Ln;
import main.java.logs.Log;
import main.java.trigs.Cos;
import main.java.trigs.Sec;
import main.java.trigs.Sin;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import trigs.MocksTrigs;

public class MyFunctionTest {
    private final Double EPS = 0.000_000_001;
    private static MocksTrigs mocksTrigs = new MocksTrigs();
    private static MockLogs mocksLogs = new MockLogs();
    private main.java.MyFunction myFunction;


    @BeforeAll
    static void init() {
        mocksTrigs.mockAll();
        mocksLogs.mockAll();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/csv_in/func_csv")
    void testMyFunctionNotMockOnlyLog(double value, double expected) {
        Ln ln = new Ln();
        myFunction = new MyFunction(mocksTrigs.secMock, mocksLogs.lnMock, new Log(ln));
        Assertions.assertEquals(
                expected, myFunction.function_solve(value, EPS), EPS);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/csv_in/func_csv")
    void testMyFunctionNotMockOnlyLn(double value, double expected) {
        myFunction = new MyFunction(mocksTrigs.secMock, new Ln(), mocksLogs.logMock);
        Assertions.assertEquals(
                expected, myFunction.function_solve(value, EPS), EPS);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/csv_in/func_csv")
    void testMyFunctionNotMockOnlySec(double value, double expected) {
        myFunction = new MyFunction(new Sec(new Cos(new Sin())), mocksLogs.lnMock, mocksLogs.logMock);
        Assertions.assertEquals(
                expected, myFunction.function_solve(value, EPS), EPS);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/csv_in/func_csv")
    void testMyFunction(double value, double expected) {
        myFunction = new MyFunction(mocksTrigs.secMock, mocksLogs.lnMock, mocksLogs.logMock);
        Assertions.assertEquals(expected, myFunction.function_solve(value, EPS), EPS);
    }


}
