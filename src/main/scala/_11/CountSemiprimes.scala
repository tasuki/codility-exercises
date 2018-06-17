package _11

import scala.annotation.tailrec

object CountSemiprimes {
  def eratosthenes(upTo: Int): List[Int] = {
    @tailrec
    def recurse(current: Int, primes: List[Boolean]): List[Boolean] = {
      val remove = (0 to upTo).toList
        .map(x => x <= current || x % current != 0)

      val newPrimes = (primes zip remove) map { case (a, b) => a && b }
      val next = newPrimes.indexWhere(identity, current + 1)

      if (next == -1) newPrimes
      else recurse(next, newPrimes)
    }

    val primes = recurse(2, List.fill(upTo + 1)(true))
    primes.zipWithIndex.filter(_._1).map(_._2).drop(2)
  }

  def inListBools(lst: List[Int]): Vector[Boolean] = {
    @tailrec
    def recurse(lst: List[Int], cur: Int, bools: List[Boolean]): List[Boolean] =
      lst match {
        case h :: t if h == cur =>
          recurse(t, cur + 1, true :: bools)
        case h :: t =>
          recurse(lst, cur + 1, false :: bools)
        case Nil =>
          bools
      }

    recurse(lst, 0, Nil).reverse.toVector
  }

  def countInRange(primes: Vector[Boolean])(range: (Int, Int)): Int =
    primes.slice(range._1, range._2).count(identity)

  def solution(n: Int, p: Array[Int], q: Array[Int]): Array[Int] = {
    val primes = eratosthenes(n)

    val semiprimes = (for {
      p1 <- primes
      p2 <- primes
    } yield p1 * p2).distinct.sorted

    (p zip q.map(_ + 1)).map(countInRange(inListBools(semiprimes)))
  }
}
