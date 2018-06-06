package _05

import scala.annotation.tailrec

object GenomicRangeQuery {
  def solution(s: String, p: Array[Int], q: Array[Int]): Array[Int] = {
    @tailrec
    def getPrefixSumArray(
      c: Char,
      sequence: List[Char],
      count: Int = 0,
      lst: List[Int] = Nil
    ): Array[Int] =
      sequence match {
        case h :: t if h == c =>
          getPrefixSumArray(c, t, count + 1, count + 1 :: lst)
        case h :: t =>
          getPrefixSumArray(c, t, count, count :: lst)
        case Nil =>
          lst.reverse.toArray
      }

    val seq = s.toList
    val a = getPrefixSumArray('A', seq)
    val c = getPrefixSumArray('C', seq)
    val g = getPrefixSumArray('G', seq)
    val t = getPrefixSumArray('T', seq)

    def isInRange(psArray: Array[Int], fromIndex: Int, toIndex: Int): Boolean = {
      val from =
        if (fromIndex == 0) 0
        else psArray(fromIndex - 1)

      val to = psArray(toIndex)

      from - to != 0
    }

    def findMinInRange(index: Int): Int =
      if      (isInRange(a, p(index), q(index))) 1
      else if (isInRange(c, p(index), q(index))) 2
      else if (isInRange(g, p(index), q(index))) 3
      else if (isInRange(t, p(index), q(index))) 4
      else throw new Exception("unexpected")

    Array.range(0, p.length).map(findMinInRange)
  }
}
