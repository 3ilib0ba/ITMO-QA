package trigs;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.mockito.Mockito;

import java.io.FileReader;
import java.io.Reader;

import static org.mockito.Mockito.mock;

public class MocksTrigs {
    private final Double EPS = 0.000_000_001;

    public main.java.trigs.Sin sinMock = mock(main.java.trigs.Sin.class);
    public main.java.trigs.Cos cosMock = mock(main.java.trigs.Cos.class);
    public main.java.trigs.Sec secMock = mock(main.java.trigs.Sec.class);

    public void setSinMock() {
        try {
            Reader reader = new FileReader("src/main/resources/csv_in/sin_csv");
            Iterable<CSVRecord> records = CSVFormat.DEFAULT.parse(reader);
            for (CSVRecord record : records) {
                Mockito.when(sinMock.sin(Double.parseDouble(record.get(0)), EPS))
                        .thenReturn(Double.valueOf(record.get(1)));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void setCosMock() {
        try {
            Reader reader = new FileReader("src/main/resources/csv_in/cos_csv");
            Iterable<CSVRecord> records = CSVFormat.DEFAULT.parse(reader);
            for (CSVRecord record : records) {
                Mockito.when(cosMock.cos(Double.parseDouble(record.get(0)), EPS))
                        .thenReturn(Double.valueOf(record.get(1)));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void setSecMock() {
        try {
            Reader reader = new FileReader("src/main/resources/csv_in/sec_csv");
            Iterable<CSVRecord> records = CSVFormat.DEFAULT.parse(reader);
            for (CSVRecord record : records) {
                Mockito.when(secMock.sec(Double.parseDouble(record.get(0)), EPS))
                        .thenReturn(Double.valueOf(record.get(1)));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void mockAll() {
        setSinMock();
        setCosMock();
        setSecMock();
    }
}
