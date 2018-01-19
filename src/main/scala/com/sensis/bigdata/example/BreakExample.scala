package com.sensis.bigdata.example

import scala.util.control.Breaks

object BreakExample {

  def breakExample1 = {
    val numList = List(1,2,3,4,5,6,7,8,9,10);

    val loop = new Breaks;

    loop.breakable {
      for( a <- numList){
        println( "Value of a: " + a );

        if( a == 4 ){
          loop.break;
        }
      }
    }
    println( "After the loop" );

  }

  def breakExample2 = {

    val numList1 = List(1,2,3,4,5);
    val numList2 = List(11,12,13);

    val outer = new Breaks;
    val inner = new Breaks;

    outer.breakable {
      for( a <- numList1){
        println( "Value of a: " + a );

        inner.breakable {
          for( b <- numList2){
            println( "Value of b: " + b );

            if( b == 12 ){
              inner.break;
            }
          }
        } // inner breakable
      }
    } // outer breakable.

  }

  def main(args: Array[String]): Unit = {

    // breakExample1
    breakExample2

  }


}
