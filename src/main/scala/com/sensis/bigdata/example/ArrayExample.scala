package com.sensis.bigdata.example

/**
  * Created by orp on 28/06/17.
  */
object ArrayExample {

  val numerals = Array("I", "II", "III")
  val daysOfWeekList = List("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun")

  def main(args: Array[String]): Unit = {
//    println(numerals(2))

    numerals(2) = "KKKK"

    for (i <- numerals) {
      println {i}
    }

    println("\ndaysOfWeekList --\n")
    for (day <- daysOfWeekList) {println(day)}

    val newDaysList = for (day <- daysOfWeekList) yield {
      day match {
        case "Mon" => "Crazy Monday!!"
        case other_day => other_day
      }
    }
    println("new days: " + newDaysList)

    println("\nfor loop until usage --\n") // offset by 1
    for(i <- 0 until daysOfWeekList.size) {
      println(i)
    }

    println("\nfor loop pattern guards --\n")
    for (day <- daysOfWeekList if day == "Mon") {
      println("Manic Monday!!!!!!")
    }

    println("\nnested for loops --\n")
    for{i <- 0 until 7
        j <- daysOfWeekList} {
      println(s"$i, $j")
    }

  }

}
