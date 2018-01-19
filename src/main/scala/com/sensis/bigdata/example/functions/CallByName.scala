package com.sensis.bigdata.example.functions

/**
  * https://www.tutorialspoint.com/scala/functions_call_by_name.htm
  */
object CallByName {

  def main(args: Array[String]) {

    delayed(time());

    println("\n--------------------------------\n")

    nonDelay(time());
  }

  def time() = {
    println("Getting time in nano seconds")
    System.nanoTime
  }

  def delayed( t: => Long ) = {
    println("In delayed method")
    println("Param: " + t)
  }

  def nonDelay( t: Long ) = {
    println("In nonDelay method")
    println("Param: " + t)
  }

}
