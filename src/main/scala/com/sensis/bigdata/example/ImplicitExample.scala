package com.sensis.bigdata.example

/**
  * https://www.tutorialspoint.com/scala/scala_classes_objects.htm
  */
object Run {

  implicit class IntTimes(x: Int) {

    def times [A] (f: =>A): Unit = {
      def loop(current: Int): Unit =

        if(current > 0){
          f
          loop(current - 1)
        }
      loop(x)
    }

    def getMsg [A] (f: =>A): String = {

      def loop(current: Int): String = {

        if (current > 0) {
          f
          println("inside loop: " + current)
          loop(current - 1)
        }

        "return to outer"
      }

      loop(x)
      "final return"

    }
  }
}

import com.sensis.bigdata.example.Run._

object ImplicitExample {

  def main(args: Array[String]) {
    val rt = 2 getMsg println("hello")
    println(rt)

    3 times println("Again")
  }

}
