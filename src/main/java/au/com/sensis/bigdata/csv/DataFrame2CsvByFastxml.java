package au.com.sensis.bigdata.csv;

import au.com.sensis.bigdata.csv.model.Product2;
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

        CsvSchema schema = mapper.schemaFor(Product2.class)
                .withColumnSeparator(',')
                .withHeader();
        return mapper.writer(schema);
    }

    public static  ObjectWriter createWriter() {
        CsvMapper mapper = new CsvMapper();
        CsvSchema schema = mapper.schemaFor(Product2.class)
                .withColumnSeparator(',')
                .withHeader();
        return mapper.writer(schema);
    }

    public static void saveToLocal(ObjectWriter writer,
                     List rows) throws IOException {

        File output = new File("/var/tmp/csv-xml.csv");
        FileUtils.write(output, writer.writeValueAsString(rows));
    }

    public static void main(String[] args) throws IOException {

        List<Product2> arrayList2 = new ArrayList();

        arrayList2.add(new Product2("1", "HTC", "2017", 123));
        arrayList2.add(new Product2("2", "Sony", "2017", 345));
        arrayList2.add(new Product2("3", "Samsung", "2017", 1233));

        ObjectWriter writer = createWriter();
        saveToLocal(writer, arrayList2);

    }
}
