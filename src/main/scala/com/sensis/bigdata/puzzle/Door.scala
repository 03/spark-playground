package com.sensis.bigdata.puzzle

class DoorScala (val id: Int) {

  var isClosed: Boolean = true
  def visit = {isClosed = !isClosed}

  override def toString = "DoorScala(%d, %s)".format(id, if (isClosed) "Closed" else "Opened")
}

object DoorScala {

  def main(args: Array[String]): Unit = {

    val num_of_doors = 100

    // init doors
    val doors = new Array[DoorScala](num_of_doors)
    for (i <- 1 to num_of_doors) {
      doors(i-1) = new DoorScala(i)
    }

    // visit doors
    for {
      i <- 1 to num_of_doors
      k <- 1 to num_of_doors
      if ( k % i == 0 )
    } doors(k-1).visit

    // show opened doors
    doors.filter(!_.isClosed).foreach(println(_))

  }

}