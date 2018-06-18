package _11

import scala.annotation.tailrec

object CountSemiprimes {
  def eratosthenes(upTo: Int): List[Int] = {
    val arr = Array.fill(upTo + 1)(true)

    @tailrec
    def recurse(current: Int): List[Boolean] = {
      var i = current + current
      while (i <= upTo) {
        arr(i) = false
        i += current
      }

      val next = arr.indexWhere(identity, current + 1)
      if (next == -1) arr.toList
      else recurse(next)
    }

    recurse(2).zipWithIndex.filter(_._1).map(_._2).drop(2)
  }

  @tailrec
  def getSemiprimes(primes: List[Int], limit: Int, acc: List[Int] = Nil)(prime: Int): List[Int] = {
    primes match {
      case Nil =>
        acc
      case h :: t =>
        val next = prime * h
        if (next > limit)
          acc
        else
          getSemiprimes(t, limit, next :: acc)(prime)
    }
  }

  def prefixSum(primes: List[Int], upTo: Int): Vector[Int] = {
    @tailrec
    def recurse(primes: List[Int], cur: Int, counts: List[Int]): List[Int] =
      primes match {
        case _ if cur > upTo =>
          counts
        case h :: t if h == cur =>
          recurse(t, cur + 1, counts.head + 1 :: counts)
        case _ =>
          recurse(primes, cur + 1, counts.head :: counts)
      }

    recurse(primes, 1, List(0)).reverse.toVector
  }

  def countInRange(semiprimes: Vector[Int])(range: (Int, Int)): Int =
    semiprimes(range._2) - semiprimes(range._1)

  def solution(n: Int, p: Array[Int], q: Array[Int]): Array[Int] = {
    val primes = eratosthenes(n)
    val semiprimes = primes.flatMap(getSemiprimes(primes, n)).distinct.sorted
    (p.map(_ - 1) zip q).map(countInRange(prefixSum(semiprimes, n)))
  }
}
