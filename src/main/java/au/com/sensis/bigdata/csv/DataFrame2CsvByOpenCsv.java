package au.com.sensis.bigdata.csv;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;

import java.io.IOException;
import java.io.StringReader;
import java.util.List;

/**
 * Created by orp on 01/12/17.
 *
 * http://opencsv.sourceforge.net/apidocs/com/opencsv/bean/MappingStrategy.html
 * http://bethecoder.com/applications/tutorials/csv/open-csv/csv-to-bean-using-header-to-column-name-mapping-strategy.html
 */
public class DataFrame2CsvByOpenCsv {

    public static void main(String[] args) throws IOException {

        CsvToBean<Product> bean = new CsvToBean<>();
        //Define strategy
        HeaderColumnNameMappingStrategy<Product> strategy =
                new HeaderColumnNameMappingStrategy<>();
        strategy.setType(Product.class);

        //CSV header names matching with bean properties
        String csvContent =
                "id,name,quantity,created\n" +
                        "1,Sriram,21,2012\n" +
                        "2,Sudhakar,29,2001";

        //Parse the CSV
        List<Product> products = bean.parse(strategy, new StringReader(csvContent));
        System.out.println("1> \n" + products);

        csvContent =
                "id,name,quantity\n" +
                        "1,Sriram,21\n" +
                        "2,Sudhakar,29";

        //Parse the CSV
        products = bean.parse(strategy, new StringReader(csvContent));
        System.out.println("2> \n" + products);

    }
}
