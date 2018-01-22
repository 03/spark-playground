package com.sensis.bigdata.example

/**
  * https://www.tutorialspoint.com/scala/scala_strings.htm
  */
object StringExample {

  def main(args: Array[String]): Unit = {

    // Creating Format Strings
    val floatVar = 12.456
    val intVar = 2000
    val stringVar = "Hello, Scala!"

    val fs = printf("The value of the float variable is " + "%f, while the value of the integer " + "variable is %d, and the string" + "is %s", floatVar, intVar, stringVar);
    println(fs)

    // String Interpolation
    val name = "James"
    println(s"Hello, $name") //output: Hello, James
    println(s"1 + 1 = ${1 + 1}") //output: 1 + 1 = 2

    val height = 1.9d
    println(f"$name%s is $height%2.2f meters tall") //James is 1.90 meters tall

    println(raw"Result = \n a \n b")

  }

}
