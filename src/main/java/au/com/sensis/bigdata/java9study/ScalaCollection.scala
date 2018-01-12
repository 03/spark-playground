package au.com.sensis.bigdata.java9study

/**
  * http://allaboutscala.com/tutorials/chapter-8-beginner-tutorial-using-scala-collection-functions/scala-collect-function/
  * https://docs.scala-lang.org/overviews/collections/conversions-between-java-and-scala-collections.html
  */
object ScalaCollection {

  val numerals = Array("I", "II", "III")
  val daysOfWeekList = List("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun")
  val daysOfWeekSet = Set("Mon", "Tue", "Wed", "Thu", "Fri", "Sat")
  val daysOfWeekMap = Map("Mon" -> 1, "Tue" -> 2)

  def main(args: Array[String]) = {
    println(daysOfWeekList)
    println(daysOfWeekSet)
    println(daysOfWeekMap)

    val newList: Seq[String] = daysOfWeekList.collect({case dayOfWeek: String => dayOfWeek + "_new"})
    println(newList)
  }

}
