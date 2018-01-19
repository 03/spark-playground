package com.sensis.bigdata.example.functions

object VariableArguments {

  def main(args: Array[String]) {
    printStrings("Hello", "Scala", "Python");
  }

  def printStrings( args:String* ) = {
    var i : Int = 0;

    for( arg <- args ){
      println("Arg value[" + i + "] = " + arg );
      i += 1;
    }
  }

}
