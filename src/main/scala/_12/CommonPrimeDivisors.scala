package _12

import scala.annotation.tailrec

import _10.CountFactors

object CommonPrimeDivisors {
  @tailrec
  def gcd(a: Int, b: Int): Int =
    if (b == 0) a
    else gcd(b, a % b)

  def hasSamePrimeFactors(a: Int, b: Int): Boolean = {
    val div = gcd(a, b)

    if (div == 1) a == b
    else {
      val commonFactors = CountFactors.primeFactors(div)
      val uniqueFactors =
        CountFactors.primeFactors(a / div) ++
        CountFactors.primeFactors(b / div)

      uniqueFactors.forall(commonFactors.contains)
    }
  }

  def solution(a: Array[Int], b: Array[Int]): Int =
    (a zip b)
      .map((hasSamePrimeFactors _).tupled)
      .count(identity)
}
