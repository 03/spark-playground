package com.sensis.bigdata.robot


object Direction extends Enumeration {

  type Direction = Value
  val EAST, WEST, SOUTH, NORTH = Value

}

class Robot (max_x : Int, max_y : Int) {

  import com.sensis.bigdata.robot.Direction._

  // init position: The origin (0,0) can be considered to be the SOUTH WEST most corner
  var x = 0
  var y = 0
  var direction = NORTH

  def left = {
    direction = direction match {
      case NORTH => WEST
      case EAST => NORTH
      case SOUTH => EAST
      case WEST => SOUTH
    }

    println("Facing " + direction)
  }

  def right = {
    direction = direction match {
      case NORTH => EAST
      case EAST => SOUTH
      case SOUTH => WEST
      case WEST => NORTH
    }

    println("Facing " + direction)
  }

  def report = println(current_position)
  private def current_position = s"$x, $y, $direction"

  def move = {

    var _x = x
    var _y = y

    direction match {
      case NORTH => _y += 1
      case EAST => _x += 1
      case SOUTH => _y -= 1
      case WEST => _x -= 1
    }

    if (0 <= _x && _x < max_x && 0 <=_y && _y< max_y) {
      x = _x
      y = _y
      println("Moved to " + current_position)

    } else {
      println("Invalid position, ignored..")
    }

  }

  def place(_x: Int, _y:Int, _direction: Direction) = {

    if (0 <= _x && _x < max_x && 0 <=_y && _y< max_y) {
      x = _x
      y = _y
      direction = _direction
      println("Place at " + current_position)

    } else {
      println("Invalid position, ignored..")
    }

  }

}

object Robot {

  def main(args: Array[String]): Unit = {

    val robot = new Robot(5, 5)

    robot.place(6, 3,Direction.NORTH)
    robot.report

    robot.place(4, 3,Direction.EAST)
    robot.report

    robot.left
    robot.left
    robot.left

    robot.right

    robot.move
    robot.move
    robot.move
    robot.move
    robot.move


  }
}
