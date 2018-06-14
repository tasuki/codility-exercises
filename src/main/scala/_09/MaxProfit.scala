package _09

import scala.annotation.tailrec

object MaxProfit {
  @tailrec
  def getProfit(lst: List[Int], lowestBase: Int, maxProfit: Int): Int =
    lst match {
      case h :: t if h < lowestBase =>
        getProfit(t, h, maxProfit)
      case h :: t if h - lowestBase > maxProfit =>
        getProfit(t, lowestBase, h - lowestBase)
      case h :: t =>
        getProfit(t, lowestBase, maxProfit)
      case Nil =>
        maxProfit
    }

  def solution(a: Array[Int]): Int =
    getProfit(a.toList, 10000000, 0)
}
