package au.com.sensis.bigdata.java9study

/**
  * http://allaboutscala.com/tutorials/chapter-8-beginner-tutorial-using-scala-collection-functions/scala-collect-function/
  * https://docs.scala-lang.org/overviews/collections/conversions-between-java-and-scala-collections.html
  *
  * https://app.pluralsight.com/score/learning-check/scala-for-java-developers/next
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

    var rs = List(List(Option(1), Option(2)), List(Option(3), Option(4))).flatMap(a => a).map(b => b.get).sum;
    println(rs)

    rs = List(List(Option(1), Option(2)), List(Option(3), Option(4))).flatMap(a => a.flatMap(b => b).map(c => c * 2)).sum
    println(rs)

    val nullSeries=List(Option("A"), Option(null), Option("B"), None).flatten
    println(nullSeries)

  }

}
