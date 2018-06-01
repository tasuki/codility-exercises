package _03

import scala.annotation.tailrec

object TapeEquilibrium {

  @tailrec
  def find(
    arr: Array[Int],
    i: Int,
    left: Int,
    right: Int,
    bestScore: Int
  ): Int =
    if (i == arr.length) bestScore
    else {
      val potentialScore = (left - right).abs
      val newBest =
        if (potentialScore > bestScore) bestScore
        else potentialScore

      find(arr, i + 1, left + arr(i), right - arr(i), newBest)
    }

  def solution(arr: Array[Int]): Int =
    find(arr, 1, arr(0), arr.slice(1, arr.length).sum, 1000000)
}
