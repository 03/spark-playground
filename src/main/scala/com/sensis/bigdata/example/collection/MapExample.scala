package com.sensis.bigdata.example.collection

/**
  * https://www.tutorialspoint.com/scala/scala_maps.htm
  */
object MapExample {

  def main(args: Array[String]): Unit = {
    var colors = Map("red" -> "#FF0000", "azure" -> "#F0FFFF", "peru" -> "#CD853F")

    var nums: Map[Int, Int] = Map()

    println( "Keys in colors : " + colors.keys )
    println( "Values in colors : " + colors.values )
    println( "Check if colors is empty : " + colors.isEmpty )
    println( "Check if nums is empty : " + nums.isEmpty )

    nums = nums.++ (Map(1 -> 23))
    println( "Check if nums is empty after adding element: " + nums.isEmpty )

  }
}
