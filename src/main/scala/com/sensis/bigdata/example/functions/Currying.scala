package com.sensis.bigdata.example.functions

/**
  *
  * https://www.tutorialspoint.com/scala/currying_functions.htm
  *
  * def strcat(s1: String)(s2: String) = s1 + s2
  * ->
  * def strcat(s1: String) = (s2: String) => s1 + s2
  */
object Currying {

  def main(args: Array[String]) {
    val str1 = "Hello, "
    val str2 = "Scala!"

    println( "str1 + str2 = " +  strcat(str1)(str2) )
  }

  def strcat(s1: String)(s2: String): String = {
    s1 + s2
  }

}
