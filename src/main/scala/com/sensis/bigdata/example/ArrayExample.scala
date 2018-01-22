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

    val z = new Array[String](3)
    z(0) = "Zara"; z(1) = "Nuha"; z(4/2) = "Ayan"
    // var z = Array("Zara", "Nuha", "Ayan")
    for(i <- z) {
      println(i)
    }


    import Array._
    /*
    Scala does not directly support various array operations and provides various methods to process arrays
    in any dimension. If you want to use the different methods then it is required to import Array._ package.
     */
    val myMatrix = ofDim[Int](3,3)

    println("\nBuild and print a matrix")
    for (i <- 0 to 2) {
      for ( j <- 0 to 2) {
        myMatrix(i)(j) = j;
        print(" " + myMatrix(i)(j));
      }
    }

    val myList1 = range(10, 20, 2)
    val myList2 = range(10, 20)

    // Print all the array elements
    for ( x <- myList1 ) {
      print( " " + x )
    }
    println
    for ( x <- myList2 ) {
      print( " " + x )
    }

    println("\nConcatenate Arrays:")
    val myList3 = concat(myList1, myList2)
    // Concatenate Arrays
    for ( x <- myList3 ) {
      print( " " + x )
    }

    println("\nPrefilled Array:")
    val prefilledArray = Array.fill(3){scala.util.Random.nextInt(5)}
    for ( x <- prefilledArray ) {
      print( " " + x )
    }

    println("\nTabulated Array:")
    val tabulatedArray = Array.tabulate(3){n => n * n}
    for ( x <- tabulatedArray ) {
      print( " " + x )
    }



  }

}
