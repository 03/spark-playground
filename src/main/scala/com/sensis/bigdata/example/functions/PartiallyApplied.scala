package com.sensis.bigdata.example.functions

import java.util.Date

object PartiallyApplied {

  def main(args: Array[String]) {
    val date = new Date
    log(date, "message1")

    Thread.sleep(1000)
    log(date, "message2")

    Thread.sleep(1000)
    log(date, "message3")


    println("\n------------- Partially Applied Functions -------------")
    val logWithDateBound = log(date, _ : String)

    logWithDateBound("message1")
    Thread.sleep(1000)

    logWithDateBound("message2")
    Thread.sleep(1000)

    logWithDateBound("message3")

  }

  def log(date: Date, message: String)  = {
    println(date + "----" + message)
  }

}
