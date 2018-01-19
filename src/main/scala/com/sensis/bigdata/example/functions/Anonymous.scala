package com.sensis.bigdata.example.functions

object Anonymous {

  def main(args: Array[String]): Unit = {

    val inc = (x: Int) => x + 1

    val x: Int = inc(7) - 1

    println(x.intValue())

    val mul = (x: Int, y: Int) => x * y

    println(mul(3, 4))

    val userDir = () => { System.getProperty("user.dir") }

    println( userDir.apply() )

  }

}
