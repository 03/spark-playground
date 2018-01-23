package com.sensis.bigdata.example.collection

/**
  * https://www.tutorialspoint.com/scala/scala_sets.htm
  */
object SetExample {

  def main(args: Array[String]): Unit = {

    val fruit1 = Set("apples", "oranges", "pears")
    val fruit2 = Set("mangoes", "banana")

    val fruit3 = fruit2 + "pineapple" - "banana";
    println( "fruit3 : " + fruit3 )
    println( "fruit3.tail : " + fruit3.tail )

    // use two or more sets with ++ as operator
    var fruit = fruit1 ++ fruit2
    println( "fruit1 ++ fruit2 : " + fruit )

    // use two sets with ++ as method
    fruit = fruit1.++(fruit2)
    println( "fruit1.++(fruit2) : " + fruit )

    val num = Set(5,6,9,20,30,45)
    // find min and max of the elements
    println( "Min element in Set(5,6,9,20,30,45) : " + num.min )
    println( "Max element in Set(5,6,9,20,30,45) : " + num.max )

    val num1 = Set(5,6,9,20,30,45)
    val num2 = Set(50,60,9,20,35,55)
    // find common elements between two sets
    println( "num1.&(num2) : " + num1.&(num2) )
    println( "num1.intersect(num2) : " + num1.intersect(num2) )
    println( "num1.difference(num2) : " + num1.&~(num2) )

  }
}
