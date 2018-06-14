package _09

import scala.annotation.tailrec

object MaxSliceSum {
  @tailrec
  def getSliceSum(lst: List[Int], currentSum: Int, maxSum: Int): Int =
    lst match {
      case h :: t =>
        val newSum = math.max(h + currentSum, h)
        val newMax = math.max(maxSum, newSum)
        getSliceSum(t, newSum, newMax)
      case Nil =>
        maxSum
    }

  def solution(a: Array[Int]): Int = {
    val lst = a.toList
    getSliceSum(lst.tail, lst.head, lst.head)
  }
}
