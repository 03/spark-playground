/**
  * http://allaboutscala.com/tutorials/chapter-3-beginner-tutorial-using-classes-scala/scala-tutorial-learn-use-implicit-class-extension-methods/
  */

package com.sensis.bigdata.example

case class Donut(name: String, price: Double, productCode: Option[Long] = None)

object DonutImplicits {
  implicit class AugmentedDonut(donut: Donut) {
    def uuid: String = s"${donut.name} - ${donut.productCode.getOrElse(12345)}"
  }
}

import DonutImplicits._
object RunMe {

  def main(args: Array[String]) {
    println("\nStep 1: How to define a case class to represent a Donut object")
    println("\nStep 2: How to create instances or objects for the Donut case class")

    val vanillaDonut: Donut = Donut("Vanilla", 1.50)
    println(s"Vanilla donut name = ${vanillaDonut.name}")
    println(s"Vanilla donut price = ${vanillaDonut.price}")
    println(s"Vanilla donut produceCode = ${vanillaDonut.productCode}")

    println("\nStep 3: How to define an implicit class to augment or extend the Donut object with a uuid field")
    println("\nStep 4: How to import and use the implicit class AugmentedDonut from Step 3")

    println(s"Vanilla donut uuid = ${vanillaDonut.uuid}")
  }

}



