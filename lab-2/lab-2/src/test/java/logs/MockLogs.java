package logs;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.mockito.Mockito;

import java.io.FileReader;
import java.io.Reader;

import static org.mockito.Mockito.mock;

public class MockLogs {
    private final Double EPS = 0.000_000_001;

    public main.java.logs.Ln lnMock = mock(main.java.logs.Ln.class);
    public main.java.logs.Log logMock = mock(main.java.logs.Log.class);

    public void setLnMock() {
        try {
            Reader reader = new FileReader("src/main/resources/csv_in/ln_csv");
            Iterable<CSVRecord> records = CSVFormat.DEFAULT.parse(reader);
            for (CSVRecord record : records) {
                Mockito.when(lnMock.ln(Double.parseDouble(record.get(0)), EPS))
                        .thenReturn(Double.valueOf(record.get(1)));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void setLogMock() {
        try {
            Reader reader = new FileReader("src/main/resources/csv_in/log2_csv");
            Iterable<CSVRecord> records = CSVFormat.DEFAULT.parse(reader);
            for (CSVRecord record : records) {
                Mockito.when(logMock.log(Double.parseDouble(record.get(0)), Double.parseDouble(record.get(1)), EPS))
                        .thenReturn(Double.valueOf(record.get(2)));
            }
            reader = new FileReader("src/main/resources/csv_in/log3_csv");
            records = CSVFormat.DEFAULT.parse(reader);
            for (CSVRecord record : records) {
                Mockito.when(logMock.log(Double.parseDouble(record.get(0)), Double.parseDouble(record.get(1)), EPS))
                        .thenReturn(Double.valueOf(record.get(2)));
            }
            reader = new FileReader("src/main/resources/csv_in/log5_csv");
            records = CSVFormat.DEFAULT.parse(reader);
            for (CSVRecord record : records) {
                Mockito.when(logMock.log(Double.parseDouble(record.get(0)), Double.parseDouble(record.get(1)), EPS))
                        .thenReturn(Double.valueOf(record.get(2)));
            }
            reader = new FileReader("src/main/resources/csv_in/log10_csv");
            records = CSVFormat.DEFAULT.parse(reader);
            for (CSVRecord record : records) {
                Mockito.when(logMock.log(Double.parseDouble(record.get(0)), Double.parseDouble(record.get(1)), EPS))
                        .thenReturn(Double.valueOf(record.get(2)));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public void mockAll() {
        setLnMock();
        setLogMock();
    }
}
