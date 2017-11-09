package au.com.sensis.bigdata.udf;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.apache.spark.sql.api.java.UDF1;
import scala.collection.mutable.WrappedArray;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Slf4j
public class ArrayToSetUDF implements UDF1<Object, Set<String>> {

    public static final String elementSeparator = "#--#";

    @Override
    public Set<String> call(Object o) throws Exception {

        if (o == null) {
            return null;
        }
        if (o instanceof WrappedArray) {

            WrappedArray wrappedArray = (WrappedArray) o;

            String[] stringArray = StringUtils.splitByWholeSeparator(wrappedArray.mkString(elementSeparator), elementSeparator);

            // convert list to set, remove duplicates
            return new HashSet<>(Arrays.asList(stringArray));
        }

        return null;
    }

}
