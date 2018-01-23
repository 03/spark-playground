package com.sensis.bigdata.example

import scala.util.matching.Regex

object RegexExample {

  def main(args: Array[String]) {
    val pattern = "Scala".r
    val str = "Scala is Scalable and cool"

    println(pattern findFirstIn str)
    println(pattern findAllIn str)

    val pattern2 = new Regex("(S|s)cala")
    println((pattern2 findAllIn str).mkString(","))

    println(pattern replaceFirstIn(str, "Java"))

  }

}
