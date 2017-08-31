package com.sensis.bigdata.example

/**
  * Created by orp on 30/06/17.
  */
object DateExample {

  def main(args: Array[String]): Unit = {

    //Determine the date for yesterday//Determine the date for yesterday
    val cal: java.util.Calendar = java.util.Calendar.getInstance
    cal.setTime(new java.util.Date)
    cal.add(java.util.Calendar.DATE, -1)
    val yesterday: String = new java.text.SimpleDateFormat("yyyyMMdd").format(cal.getTime)
    println("Date - " + yesterday)
  }

}
