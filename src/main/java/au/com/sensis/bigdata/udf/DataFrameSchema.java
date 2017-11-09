package au.com.sensis.bigdata.udf;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.RowFactory;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.types.DataTypes;
import org.apache.spark.sql.types.StructField;
import org.apache.spark.sql.types.StructType;

import java.util.ArrayList;
import java.util.List;

import static org.apache.spark.sql.functions.*;

/**
 * Created by orp on 09/11/17.
 */
public class DataFrameSchema {

    public static void main(String[] args) {

        SparkSession sparkSession = SparkSession.builder().appName("Build a DataFrame from Scratch").master("local[*]")
                .getOrCreate();

        List<Teacher> teacherList = new ArrayList();

        List colListSample = new ArrayList();
        colListSample.add("Dave");
        colListSample.add("Angela");
        colListSample.add("Peter");

        teacherList.add(new Teacher("1", "Onizuka", 30, new String[]{"Nick", "Duck", "Nick"}, colListSample));
        teacherList.add(new Teacher("2", "Youda", 56, new String[]{"Mike", "Jeff", "Leo"}, colListSample));
        teacherList.add(new Teacher("3", "Sam", 21,  new String[]{"Copper", "Joe"}, colListSample));

        JavaSparkContext sparkContext = new JavaSparkContext(sparkSession.sparkContext());

        Dataset<Row> ds = sparkSession.createDataFrame(sparkContext.parallelize(teacherList), Teacher.class);
        ds.printSchema();
        ds.show();

        System.out.println("-----------------------------------------------\n");

        Dataset<Row> df1 = ds
                .withColumn("cols", expr("explode(studentArray)"))
                .groupBy(col("id"))
                .agg(expr("collect_set(cols)").alias("unique_cols"));
        df1.show(false);

        sparkSession.udf().register("array_to_set", new ArrayToSetUDF(), DataTypes.createArrayType(DataTypes
                .StringType));
        Dataset<Row> df2 = ds
                .withColumn("unique_col_values", callUDF("array_to_set", col("studentArray")));
        df2.show(false);


        JavaRDD<Row> rowRDD = sparkContext.parallelize(teacherList).map((Teacher row) -> RowFactory.create(row.getId(), row.getName(), row.getAge()));
        // Creates schema
        StructType schema = DataTypes.createStructType(
                new StructField[] { DataTypes.createStructField("id2", DataTypes.StringType, false),
                        DataTypes.createStructField("name2", DataTypes.StringType, false),
                        DataTypes.createStructField("age2", DataTypes.IntegerType, false),
                });
        Dataset<Row> df_schema_1 = sparkSession.sqlContext().createDataFrame(rowRDD, schema).toDF();
        df_schema_1.printSchema();
        df_schema_1.show();

    }
}
