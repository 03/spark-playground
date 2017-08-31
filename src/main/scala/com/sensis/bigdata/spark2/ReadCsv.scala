package com.sensis.bigdata.spark2

import org.apache.commons.lang.StringUtils
import org.apache.spark.sql.{Row, SparkSession}

object ReadCsv {

  private def isHtmlElement (elementString : String) : Boolean = {
    elementString.endsWith(".html")
  }

  private def pageLocalityFromURL(url: String, domain: String) : Array[String] = {
    val outputElements = new Array[String](2)
    outputElements(0) = null // locality string
    outputElements(1) = null // postcode string

    // Find the second path element after the domain within the url
    val urlElements = url.substring(domain.length + 1).split("/")
    if (urlElements.length >= 2) { // confirm locality element is not invalid
      if (!isHtmlElement(urlElements(1))) { // Determine parts of the locality element
        val localityElements = urlElements(1).split("-")
        if (localityElements.length == 1) { // either locality or postcode
          if (StringUtils.isNumeric(urlElements(1))) outputElements(1) = urlElements(1)
          else outputElements(0) = urlElements(1)
        }
        else {
          val lastLocalityElement = localityElements(localityElements.length - 1)
          // determine if last element is 4 digit numeric (postcode)
          if ((lastLocalityElement.length == 4) && StringUtils.isNumeric(lastLocalityElement)) { // locality contains postcode
            outputElements(0) = urlElements(1).substring(0, urlElements(1).lastIndexOf("-"))
            outputElements(1) = lastLocalityElement
          }
          else { // locality does NOT contain postcode
            // use entire element as locality
            outputElements(0) = urlElements(1)
          }
        }
      }
    }

    return outputElements
  }

  def main(args: Array[String]) {

    val strs = pageLocalityFromURL("http://www.yellowpages.com.au/nsw/2178/ashley-smith-partners-13136543-listing.html", "http://www.yellowpages.com.au")
    println(strs)

    val logFile = "src/main/resources/google-analytics/20160814/20170821040547/part-00000-4336371d-b6d9-4eaa-b30d-9949ac85a94b.csv" // Should be some file on your system
    val spark = SparkSession.builder.appName("Simple Application")
      .master("local[*]")
      .getOrCreate()
    val csvData = spark.read.option("header", "true").option("quoteAll", true)
      .csv(logFile).cache()

    csvData.printSchema()
    csvData.show(false)
    val csvDataSlim = csvData.select("pages", "domain");

    csvDataSlim.foreach( (row: Row) => {
      try
        pageLocalityFromURL(row.getString(0), row.getString(1))
      catch {
        case e: Exception =>
          System.out.println(row)
          e.printStackTrace()
      }

    })

  }
}
