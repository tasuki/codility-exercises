package _01

import scala.annotation.tailrec
import scala.collection.JavaConverters._

object BinaryGap {

  @tailrec
  def findFalses(
    list: List[Boolean],
    curLongest: Int = 0,
    prevLongest: Int = 0
  ): Int =
    list match {
      case Nil => prevLongest
      case false :: t => findFalses(t, curLongest + 1, prevLongest)
      case true :: t =>
        if (curLongest > prevLongest) findFalses(t, 0, curLongest)
        else findFalses(t, 0, prevLongest)
    }

  def solution(n: Int): Int = {
    findFalses(n.toBinaryString.toList.map {
      case '1' => true
      case '0' => false
      case _ => throw new Exception("unexpected char")
    })
  }
}
