package au.com.sensis.bigdata.csv;

import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by orp on 18/07/17.
 */
public class DataFrame2CsvByFastxml {

    public static PropertyNamingStrategy createReplaceNamingStrategy(final Map<String, String> replaceMap) {
        return new PropertyNamingStrategy() {

            @Override
            public String nameForGetterMethod(MapperConfig<?> config, AnnotatedMethod method, String defaultName) {
                if (replaceMap.containsKey(defaultName)) {
                    return replaceMap.get(defaultName);
                }
                // System.out.println("method.getFullName() --->> " + method.getFullName());
                return super.nameForGetterMethod(config, method, defaultName);
            }
        };

    }

    public static ObjectWriter createWriter(Map<String, String> displayMap) {
        CsvMapper mapper = new CsvMapper();
        mapper.setPropertyNamingStrategy(createReplaceNamingStrategy(displayMap));

        CsvSchema schema = mapper.schemaFor(Product.class)
                .withColumnSeparator(',')
                .withHeader();
        return mapper.writer(schema);
    }

    public static  ObjectWriter createWriter() {
        CsvMapper mapper = new CsvMapper();
        CsvSchema schema = mapper.schemaFor(Product.class)
                .withColumnSeparator(',')
                .withHeader();
        return mapper.writer(schema);
    }

    public static void saveToLocal(ObjectWriter writer, String filePath,
                     List rows) throws IOException {
        FileUtils.write(new File(filePath), writer.writeValueAsString(rows));
    }

    public static void main(String[] args) throws IOException {

        List<Product> productList = new ArrayList();

        productList.add(new Product("1", "HTC", "2017", 123));
        productList.add(new Product("2", "Sony", "2017", 345));
        productList.add(new Product("3", "Samsung", "2017", 1233));

        ObjectWriter writer = createWriter();
        saveToLocal(writer, "/var/tmp/csv-xml.csv", productList);

        // use user-defined heading map
        // Map<String, String> mapping = Map.of("id", "MyID", "name", "Name", "created", "Created", "quantity", "Count");
        Map<String, String> mapping = new HashMap<>();
        mapping.put("id", "MyID");
        mapping.put("name", "Name");
        mapping.put("created", "Created");
        mapping.put("quantity", "Count");
        saveToLocal(createWriter(mapping), "/var/tmp/csv-xml-heading.csv", productList);

    }
}
