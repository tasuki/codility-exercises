package _12

import _10.CountFactors

object CommonPrimeDivisors {
  def primeFactors(n: Int): List[Int] =
    CountFactors.primeFactors(n).distinct.sorted

  def commonPrimeDivisors(a: Int, b: Int): Boolean =
    primeFactors(a) == primeFactors(b)

  def solution(a: Array[Int], b: Array[Int]): Int =
    (a zip b)
      .map((commonPrimeDivisors _).tupled)
      .count(identity)
}
