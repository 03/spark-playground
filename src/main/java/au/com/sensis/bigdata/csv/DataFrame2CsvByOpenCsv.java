package au.com.sensis.bigdata.csv;

import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import org.apache.commons.io.ByteOrderMark;
import org.apache.commons.io.input.BOMInputStream;

import java.io.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * Created by orp on 01/12/17.
 *
 * CSV
 * http://opencsv.sourceforge.net/apidocs/com/opencsv/bean/MappingStrategy.html
 * http://bethecoder.com/applications/tutorials/csv/open-csv.html
 * https://www.callicoder.com/java-read-write-csv-file-opencsv/
 *
 * UTF-8 BOM
 * https://stackoverflow.com/questions/4897876/reading-utf-8-bom-marker
 */
public class DataFrame2CsvByOpenCsv {

    public static void main(String[] args) throws IOException {

        DataFrame2CsvByOpenCsv stub = new DataFrame2CsvByOpenCsv();
        stub.useHeaderNameMapping();
        stub.useColumnPositionMapping();
//
//        stub.readFromZipFile("testfile.zip");
        stub.readFromTextFileWithUtfBom("testfile_utf-8_valid.csv");
        stub.readLineByLine("testfile_utf-8_invalid.csv");

    }

    public void readLineByLine(String filepath) throws IOException {

        HeaderColumnNameMappingStrategy<YPAcquisioCsv> strategy =
                new HeaderColumnNameMappingStrategy<>();
        strategy.setType(YPAcquisioCsv.class);

        List<YPAcquisioCsv> list = new ArrayList<>();

        File f = new File(getClass().getClassLoader().getResource(filepath).getFile());

        InputStream inputStream = new FileInputStream(f);
        try {

            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            String header = br.readLine().replace("\uFEFF", "");

            br.lines().forEach(l -> {
                System.out.println("l = [" + l + "]");

                StringReader reader = new StringReader(header + "\n" +l);
                // conv
                CsvToBean<YPAcquisioCsv> bean = new CsvToBeanBuilder(reader)
                        .withIgnoreLeadingWhiteSpace(true)
                        .withMappingStrategy(strategy)
                        .build();
                List<YPAcquisioCsv> _list = bean.parse();
                list.add(_list.get(0));
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            inputStream.close();
            System.out.println("readFromZipFile size> " + list.size());
        }

    }

    public void readFromTextFileWithUtfBom(String filepath) throws IOException {

        HeaderColumnNameMappingStrategy<YPAcquisioCsv> strategy =
                new HeaderColumnNameMappingStrategy<>();
        strategy.setType(YPAcquisioCsv.class);

        File f = new File(getClass().getClassLoader().getResource(filepath).getFile());

        String defaultEncoding = "UTF-8";
        InputStream inputStream = new FileInputStream(f);
        try {
            BOMInputStream bOMInputStream = new BOMInputStream(inputStream);
            ByteOrderMark bom = bOMInputStream.getBOM();
            String charsetName = bom == null ? defaultEncoding : bom.getCharsetName();
            InputStreamReader reader = new InputStreamReader(new BufferedInputStream(bOMInputStream), charsetName);

            // conv
            CsvToBean<YPAcquisioCsv> bean = new CsvToBeanBuilder(reader)
                    .withIgnoreLeadingWhiteSpace(true)
                    .withMappingStrategy(strategy)
                    .build();
            List<YPAcquisioCsv> list = bean.parse();
            System.out.println("readFromZipFile size> " + list.size());

        } finally {
            inputStream.close();
        }

    }

    public void readFromZipFile(String filepath) throws IOException {

        HeaderColumnNameMappingStrategy<YPAcquisioCsv> strategy =
                new HeaderColumnNameMappingStrategy<>();
        strategy.setType(YPAcquisioCsv.class);

        ZipFile zipFile = new ZipFile(getClass().getClassLoader().getResource(filepath).getFile());
        Enumeration<? extends ZipEntry> entries = zipFile.entries();

        while(entries.hasMoreElements()){
            ZipEntry entry = entries.nextElement();
            InputStream stream = zipFile.getInputStream(entry);
            try {
                InputStreamReader reader = new InputStreamReader(
                        new BufferedInputStream(new BOMInputStream(stream)), "UTF-8");

                CsvToBean<YPAcquisioCsv> bean = new CsvToBeanBuilder(reader)
                        .withIgnoreLeadingWhiteSpace(true)
                        .withMappingStrategy(strategy)
                        .build();
                List<YPAcquisioCsv> list = bean.parse();
                System.out.println("readFromZipFile size> " + list.size());
            } finally {
                stream.close();
            }

        }
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
                        "31,Sriram,2,Chess\n" +
                        "2,Sudhakar,29,Painting";

        //Parse the CSV
        List<Student> list = bean.parse(strategy, new StringReader(csvContent));
        System.out.println("HeaderColumnNameMappingStrategy 1> \n" + list);

        csvContent =
                "\"STUDENT ID\",name,age\n" +
                        "1,Sriram,2\n" +
                        "2,Sudhakar,29";

        //Parse the CSV
        list = bean.parse(strategy, new StringReader(csvContent));
        System.out.println("HeaderColumnNameMappingStrategy 2> \n" + list);

        StringReader reader = new StringReader(csvContent);
        CsvToBean<Student> bean2 = new CsvToBeanBuilder(reader)
                .withIgnoreLeadingWhiteSpace(true)
                .withIgnoreQuotations(true)
                .withMappingStrategy(strategy)
                .build();
        List<Student> list2 = bean2.parse();
        System.out.println("HeaderColumnNameMappingStrategy 3> \n" + list2);

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

        StringReader reader = new StringReader(csvContent);
        CsvToBean<Student> bean2 = new CsvToBeanBuilder(reader)
                .withMappingStrategy(strategy)
                .build();
        List<Student> list2 = bean2.parse();
        System.out.println("ColumnPositionMappingStrategy 2> \n" + list2);

    }

}
