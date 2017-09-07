package com.sensis.bigdata.robot

import scala.io.Source


class CmdParser (robot : Robot) {

  def executeCmdsFromFile = {

    // Source.fromResource("readme.txt").getLines() in scala 2.12
    Source.fromInputStream(getClass.getResourceAsStream("/robot-cmds.txt")).getLines().foreach {

      _ match {
        case "MOVE" => robot.move
        case "LEFT" => robot.left
        case "RIGHT" => robot.right
        case "REPORT" => robot.report
        case s if s.startsWith("PLACE") => {
          // PLACE 1,2,EAST
          val cmds = s.substring(6).split(",")
          robot.place(Integer.parseInt(cmds(0)), Integer.parseInt(cmds(1)), Direction.withName(cmds(2)))
        }
      }

    }
  }

}
object CmdParser {

  def main(args: Array[String]): Unit = {

    val robot = new Robot(5, 5);
    new CmdParser(robot).executeCmdsFromFile

  }

}