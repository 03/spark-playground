package au.com.sensis.bigdata.csv;

import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by orp on 18/07/17.
 */
public class DataFrame2CsvBySparkCsv {

    public static void main(String[] args) {

        SparkSession sparkSession = SparkSession.builder().appName("Build a DataFrame from scratch").master("local[*]")
                .getOrCreate();

        List<Product> productList = new ArrayList();

        productList.add(new Product("1", "HTC", "2017", 123));
        productList.add(new Product("2", "Sony", "2017", 345));
        productList.add(new Product("3", "Samsung", "2017", 1233));
        productList.add(new Product("", null, "2016", null));
        productList.add(new Product("", null, "2014", null));

        JavaSparkContext sparkContext = new JavaSparkContext(sparkSession.sparkContext());

        Dataset<Row> df = sparkSession.createDataFrame(sparkContext.parallelize(productList), Product.class);
        df.printSchema();
        df.show();

        df
                .withColumn("added_1_empty_str", functions.lit(""))
                .withColumn("added_2_null", functions.lit(null))
                .withColumn("added_3_null", functions.lit(null))
                .withColumn("added_4_empty_str", functions.lit("hello"))
                .coalesce(1).
                write()
                .mode(SaveMode.Overwrite)
//                .format("com.databricks.spark.csv")
                .format("com.databricks.spark.csv2")
//                .format("com.databricks.spark2.csv")
//                .format("org.apache.spark.sql.json")
//                .option("quoteAll", "true")
                .option("inferSchema", "true")
                .option("header", "true")
                .option("nullValue", "")
//                .option("escape", "\"")
                .option("quoteMode", "NON_NUMERIC")
                .save("/var/tmp/sensei/csv");


        // spark 2
        /*df.coalesce(1).
                write()
                .mode(SaveMode.Overwrite)
                .option("inferSchema", "true")
                .option("header", "true")
                .option("nullValue", "")
                .option("escape", "\"")
                .option("quoteAll", "true")
                .option("timestampFormat", "yyyy-MM-dd HH:mm:ss.S")
                .csv("/var/tmp/testcsv-noquote2");*/


    }
}
