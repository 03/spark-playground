package com.sensis.bigdata.example.collection

/**
  * https://www.tutorialspoint.com/scala/scala_lists.htm
  */
object ListExample {

  def defMethod1(): Unit = {
    // List of Strings
    val fruit: List[String] = List("apples", "oranges", "pears")

    // List of Integers
    val nums: List[Int] = List(1, 2, 3, 4)

    // Empty List.
    val empty: List[Nothing] = List()

    // Two dimensional list
    val dim: List[List[Int]] =
      List(
        List(1, 0, 0),
        List(0, 1, 0),
        List(0, 0, 1)
      )
  }

  def defMethod2(): Unit = {
    // List of Strings
    val fruit = "apples" :: ("oranges" :: ("pears" :: Nil))

    // List of Integers
    val nums = 1 :: (2 :: (3 :: (4 :: Nil)))
    println(nums)

    // Empty List.
    val empty = Nil

    // Two dimensional list
    val dim = (1 :: (0 :: (0 :: Nil))) ::
      (0 :: (1 :: (0 :: Nil))) ::
      (0 :: (0 :: (1 :: Nil))) :: Nil
    println(dim)
  }

  def main(args: Array[String]): Unit = {

    defMethod1
    defMethod2

    val nums = Nil
    val fruit1 = "apples" :: ("oranges" :: ("pears" :: Nil))
    val fruit2 = "mangoes" :: ("banana" :: Nil)

    // use two or more lists with ::: operator
    var fruit = fruit1 ::: fruit2
    println( "fruit1 ::: fruit2 : " + fruit )

    println( "Head of fruit : " + fruit.head )
    println( "Tail of fruit : " + fruit.tail )
    println( "Check if fruit is empty : " + fruit.isEmpty )
    println( "Check if nums is empty : " + nums.isEmpty )

    // use two lists with Set.:::() method
    fruit = fruit1.:::(fruit2)
    println( "fruit1.:::(fruit2) : " + fruit )

    // pass two or more lists as arguments
    fruit = List.concat(fruit1, fruit2)
    println( "List.concat(fruit1, fruit2) : " + fruit  )

    val fruitWithFill = List.fill(3)("apples") // Repeats apples three times.
    println( "fruit : " + fruitWithFill  )

    val numWithFill = List.fill(10)(2)         // Repeats 2, 10 times.
    println( "num : " + numWithFill  )

    // Creates 5 elements using the given function.
    val squares = List.tabulate(6)(n => n * n)
    println( "squares : " + squares  )

    val mul = List.tabulate( 4, 5 )( _ * _ )
    println( "mul : " + mul  )

  }

}
