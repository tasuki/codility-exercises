package _07

import scala.annotation.tailrec

object StoneWall {
  @tailrec
  def find(stack: List[Int], heights: List[Int], blocks: Int): Int =
    heights match {
      case height :: heightTail =>
        stack match {
          case stackHead :: stackTail if height < stackHead =>
            find(stackTail, heights, blocks)
          case stackHead :: _ if height == stackHead =>
            find(stack, heightTail, blocks)
          case _ =>
            find(height :: stack, heightTail, blocks + 1)
        }
      case Nil =>
        blocks
    }

  def solution(heights: Array[Int]): Int =
    find(List.empty[Int], heights.toList, 0)
}
