package au.com.sensis.bigdata.csv;

import au.com.sensis.bigdata.csv.model.Product;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by orp on 18/07/17.
 */
public class DataFrame2CsvBySparkCsv {



    public static void main(String[] args) {

        SparkSession sparkSession = SparkSession.builder().appName("Build a DataFrame from Scratch").master("local[*]")
                .getOrCreate();

        List<Product> arrayList2 = new ArrayList();

        arrayList2.add(new Product("1", "HTC", "2017", 123));
        arrayList2.add(new Product("2", "Sony", "2017", 345));
        arrayList2.add(new Product("3", "Samsung", "2017", 1233));
        arrayList2.add(new Product("", null, "2016", null));
        arrayList2.add(new Product("", null, "2014", null));

        JavaSparkContext sparkContext = new JavaSparkContext(sparkSession.sparkContext());

        /*JavaRDD<Row> rowRDD = sparkContext.parallelize(arrayList).map((Product row) -> RowFactory.create(row.getId(), row.getName(), row.getCreated()));
        // Creates schema
        StructType schema = DataTypes.createStructType(
                new StructField[] { DataTypes.createStructField("id", DataTypes.StringType, false),
                        DataTypes.createStructField("name", DataTypes.StringType, false),
                        DataTypes.createStructField("createdAt", DataTypes.StringType, false),
                });

        Dataset<Row> df = sparkSession.sqlContext().createDataFrame(rowRDD, schema).toDF();*/

//        Dataset<Row> df = sparkSession.createDataFrame(sparkContext.parallelize(arrayList), Product.class);
        Dataset<Row> df = sparkSession.createDataFrame(sparkContext.parallelize(arrayList2), Product.class);
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
