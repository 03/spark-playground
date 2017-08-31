package com.sensis.bigdata.spark2

import org.apache.spark.sql.SparkSession

object SimpleApp {

  /**
    * spark-submit --class "au.com.sensis.sensei.spark2.SimpleApp" --master local[2] /home/orp/workspace/poc/spark2scala/target/scala-2.11/spark2scala_2.11-0.1.jar
    *
    * @param args
    */

  def main(args: Array[String]) {
    val logFile = "src/main/resources/google-analytics/20160814/20170821040547/part-00000-4336371d-b6d9-4eaa-b30d-9949ac85a94b.csv" // Should be some file on your system
    val spark = SparkSession.builder.appName("Simple Application")
      .master("local[*]")
      .getOrCreate()
    val logData = spark.read.textFile(logFile).cache()
    val numAs = logData.filter(line => line.contains("a")).count()
    val numBs = logData.filter(line => line.contains("b")).count()
    println(s"Lines with a: $numAs, Lines with b: $numBs")
    spark.stop()
  }
}
