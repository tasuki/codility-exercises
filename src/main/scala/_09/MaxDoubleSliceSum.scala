package _09

import scala.annotation.tailrec

object MaxDoubleSliceSum {
  @tailrec
  def getSliceSums(
    lst: List[Int],
    currentSum: Int = 0,
    sums: List[Int] = Nil
  ): List[Int] =
    lst match {
      case Nil =>
        sums.reverse
      case h :: t =>
        val newSum = math.max(h + currentSum, 0)
        getSliceSums(t, newSum, newSum :: sums)
    }

  def solution(a: Array[Int]): Int = {
    val lst = a.toList
    val before = 0 :: getSliceSums(lst.tail).reverse.tail.tail.reverse
    val after = (0 :: getSliceSums(lst.reverse.tail)).reverse.tail.tail

    (before zip after).map(x => x._1 + x._2).max
  }
}
