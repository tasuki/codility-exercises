package _05

import scala.collection.mutable.ArrayBuilder

object GenomicRangeQuery {
  def solution(s: String, p: Array[Int], q: Array[Int]): Array[Int] = {
    val sequence = s.toCharArray

    def getPrefixSumArray(c: Char): Array[Int] = {
      val builder = new ArrayBuilder.ofInt
      var count = 0

      sequence.foreach { nucleotide =>
        if (nucleotide == c) count += 1
        builder += count
      }

      builder.result
    }

    val a = getPrefixSumArray('A')
    val c = getPrefixSumArray('C')
    val g = getPrefixSumArray('G')
    val t = getPrefixSumArray('T')

    def isInRange(psArray: Array[Int], fromIndex: Int, toIndex: Int): Boolean = {
      val from =
        if (fromIndex == 0) 0
        else psArray(fromIndex - 1)

      val to = psArray(toIndex)

      from - to != 0
    }

    def findMinInRange(index: Int): Int =
      if (isInRange(a, p(index), q(index))) 1
      else if (isInRange(c, p(index), q(index))) 2
      else if (isInRange(g, p(index), q(index))) 3
      else if (isInRange(t, p(index), q(index))) 4
      else throw new Exception("unexpected")

    Array.range(0, p.length).map(findMinInRange)
  }
}
