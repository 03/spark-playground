package com.sensis.bigdata.example

object Closure {

  var factor = 3
  val multiplier = (i:Int) => i * factor

  def main(args: Array[String]) {


    println( "multiplier(1) value = " +  multiplier(1) )

    // change value now!!
    factor = 4
    println( "multiplier(2) value = " +  multiplier(2) )
  }

}
