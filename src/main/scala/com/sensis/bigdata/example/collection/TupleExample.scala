package com.sensis.bigdata.example.collection

// Unlike an array or list, a tuple can hold objects with different types.
object TupleExample {

  def main(args: Array[String]): Unit = {

    val t = (1, "hello", Console)
    // val t = new Tuple3(1, "hello", Console)
    t.productIterator.foreach{ i =>println("Value = " + i )}

    val t2 = new Tuple2("Scala", "hello")
    println("Swapped Tuple: " + t2.swap )

  }

}
