package com.sensis.bigdata.example

/**
  * http://dcapwell.github.io/scala-tour/Value%20Classes.html
  * https://docs.scala-lang.org/overviews/core/value-classes.html
  */
trait Printable extends Any {
  def print(): Unit = println(this)
}
class Wrapper(val underlying: Int) extends AnyVal with Printable

object ValueClassExample {
  def main(args: Array[String]) {
    val w = new Wrapper(3)
    w.print() // actually requires instantiating a Wrapper instance
  }
}
