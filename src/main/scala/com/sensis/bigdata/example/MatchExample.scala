package com.sensis.bigdata.example

import java.net.{MalformedURLException, URL}

/**
  * Created by orp on 30/06/17.
  */
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
