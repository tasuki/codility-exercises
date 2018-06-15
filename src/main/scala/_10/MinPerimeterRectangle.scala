package _10

import scala.annotation.tailrec

object MinPerimeterRectangle {
  def generateFactors(n: Int): List[Int] = {
    val sqrtn = math.sqrt(n).ceil.toInt

    @tailrec
    def find(cur: Int, found: List[Int]): List[Int] =
      if (cur > sqrtn) found
      else if (n % cur == 0) find(cur + 1, cur :: n / cur :: found)
      else find(cur + 1, found)

    find(1, Nil).distinct.sorted
  }

  def getSides(factors: List[Int]): (Int, Int) = {
    val i = factors.length / 2

    if (factors.length % 2 == 0)
      (factors(i - 1), factors(i))
    else
      (factors(i), factors(i))
  }

  def solution(n: Int): Int = {
    val factors = generateFactors(n)
    val (a, b) = getSides(factors)
    2 * a + 2 * b
  }
}
