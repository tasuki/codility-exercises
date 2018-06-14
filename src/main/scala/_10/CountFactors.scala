package _10

import scala.annotation.tailrec

object CountFactors {
  @tailrec
  def primeFactors(n: Int, cur: Int = 2, found: List[Int] = Nil): List[Int] =
    if (cur * cur > n) n :: found
    else if (n % cur == 0) primeFactors(n / cur, cur, cur :: found)
    else primeFactors(n, cur + 1, found)

  def solution(a: Int): Int = {
    val factors = primeFactors(a).groupBy(identity).values
    factors.map(_.length).map(_ + 1).product
  }
}
