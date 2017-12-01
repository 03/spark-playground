package au.com.sensis.bigdata.csv;

import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;

import java.io.IOException;
import java.io.StringReader;
import java.util.List;

/**
 * Created by orp on 01/12/17.
 *
 * http://opencsv.sourceforge.net/apidocs/com/opencsv/bean/MappingStrategy.html
 * http://bethecoder.com/applications/tutorials/csv/open-csv.html
 * https://www.callicoder.com/java-read-write-csv-file-opencsv/
 */
public class DataFrame2CsvByOpenCsv {

    public static void main(String[] args) throws IOException {

        DataFrame2CsvByOpenCsv stub = new DataFrame2CsvByOpenCsv();
        stub.useHeaderNameMapping();
        stub.useColumnPositionMapping();

    }

    public void useHeaderNameMapping() {

        CsvToBean<Student> bean = new CsvToBean<>();
        //Define strategy
        HeaderColumnNameMappingStrategy<Student> strategy =
                new HeaderColumnNameMappingStrategy<>();
        strategy.setType(Student.class);

        //CSV header names matching with bean properties
        String csvContent =
                "STUDENT ID,name,age,hobby\n" +
                        "1,Sriram,2,Chess\n" +
                        "2,Sudhakar,29,Painting";

        //Parse the CSV
        List<Student> list = bean.parse(strategy, new StringReader(csvContent));
        System.out.println("HeaderColumnNameMappingStrategy 1> \n" + list);

        csvContent =
                "STUDENT ID,name,age\n" +
                        "1,Sriram,2\n" +
                        "2,Sudhakar,29";

        //Parse the CSV
        list = bean.parse(strategy, new StringReader(csvContent));
        System.out.println("HeaderColumnNameMappingStrategy 2> \n" + list);

    }

    public void useColumnPositionMapping() {

        CsvToBean<Student> bean = new CsvToBean<>();
        //Define strategy
        ColumnPositionMappingStrategy<Student> strategy =
                new ColumnPositionMappingStrategy<>();
        strategy.setType(Student.class);
        strategy.setColumnMapping(new String [] { "id", "name", "age", "hobby" });

        //CSV header names matching with bean properties
        String csvContent =
                        "1,Sriram,2,Chess\n" +
                        "2,Sudhakar,29,Painting";

        //Parse the CSV
        List<Student> list = bean.parse(strategy, new StringReader(csvContent));
        System.out.println("ColumnPositionMappingStrategy 1> \n" + list);
    }

}
