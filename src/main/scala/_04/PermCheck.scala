package _04

import scala.annotation.tailrec

object PermCheck {
  @tailrec
  def isContinuous(lst: List[Int], beginsWith: Int): Boolean =
    lst match {
      case Nil => true
      case h :: t if h == beginsWith => isContinuous(t, beginsWith + 1)
      case _ => false
    }

  def solution(a: Array[Int]): Int = {
    isContinuous(a.sorted.toList, 1) match {
      case true => 1
      case false => 0
    }
  }
}
