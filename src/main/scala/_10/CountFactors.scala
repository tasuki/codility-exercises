package _10

import scala.annotation.tailrec

object CountFactors {
  def primeFactors(n: Int): List[Int] = {
    val sqrtn = math.sqrt(n).ceil.toInt

    @tailrec
    def find(n: Int, cur: Int = 2, found: List[Int] = Nil): List[Int] =
      if (cur > sqrtn) (n :: found).filter(_ != 1)
      else if (n % cur == 0) find(n / cur, cur, cur :: found)
      else find(n, cur + 1, found)

    find(n)
  }

  def solution(a: Int): Int = {
    val factors = primeFactors(a).groupBy(identity).values
    factors.map(_.length).map(_ + 1).product
  }
}
