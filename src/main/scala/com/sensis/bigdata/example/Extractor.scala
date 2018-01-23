package com.sensis.bigdata.example

import java.net.{MalformedURLException, URL}

object Extractor {

  def main(args: Array[String]) {
    println ("Apply method : " + apply("Zara", "gmail.com"));
    println ("Unapply method : " + unapply("Zara@gmail.com"));
    println ("Unapply method : " + unapply("Zara Ali"));
  }

  // The injection method (optional)
  def apply(user: String, domain: String) = {
    user +"@"+ domain
  }

  // The extraction method (mandatory)
  def unapply(str: String): Option[(String, String)] = {
    val parts = str split "@"

    if (parts.length == 2){
      Some(parts(0), parts(1))
    } else {
      None
    }
  }

}

object PatternMatchingWithExtractors {

  def main(args: Array[String]) {
    val x = PatternMatchingWithExtractors(5)
    println(x)

    x match {
      //unapply is invoked
      case PatternMatchingWithExtractors(num) => println( x +" = " + num + " / 3 ")

      case _ => println("i cannot calculate")
    }

  }

  def apply(x: Int) = x * 2

  def unapply(z: Int): Option[Int] = if (z%2==0) Some(z * 3) else None

}


object UrlExtract {

  def unapply(arg: String): Option[(String, String)] = {
    try {
      val url = new URL(arg)
      Some(url.getProtocol, url.getHost)
    } catch {
      case _:MalformedURLException => None
    }
  }

  def main(args: Array[String]): Unit = {

    val url = "http://www.google.com.au" match {
      case UrlExtract(protocal, hostName) => println(protocal + " " + hostName)
    }
  }

}