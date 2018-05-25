package _03

import scala.annotation.tailrec

object PermMissingElem {

  @tailrec
  def findHead(a: List[Int], n: Int): Int =
    a match {
      case Nil => n
      case h :: t =>
        if (n < h) n
        else if (n == h) findHead(t, n + 1)
        else findHead(t, n)
    }

  def solution(a: Array[Int]): Int =
    findHead(a.sorted.toList, 1)
}
