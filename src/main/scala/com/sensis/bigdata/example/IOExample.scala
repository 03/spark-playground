package com.sensis.bigdata.example

import java.io.{File, PrintWriter}

import scala.io.Source

object IOExample {

  def main(args: Array[String]) {

    val fileName = "test.txt"

    // Reading a Line from Command Line
    print("Please enter your input : " )
    val line = Console.readLine

    println("Thanks, you just typed: " + line)

    val writer = new PrintWriter(new File(fileName))
    writer.write("Hello Scala: " + line)
    writer.close()

    println("Following is the content read:" )

    Source.fromFile(fileName).foreach {
      print
    }

  }

}
