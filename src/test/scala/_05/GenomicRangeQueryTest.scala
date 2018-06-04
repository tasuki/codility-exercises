package _05

import org.scalatest.FlatSpec

class GenomicRangeQueryTest extends FlatSpec {
  it should "find the minimums for sample" in {
    val res = GenomicRangeQuery.solution("CAGCCTA", Array(2, 5, 0), Array(4, 5, 6))
    assert(res.toList == List(2, 4, 1))
  }

  it should "find the minimums for single" in {
    val res = GenomicRangeQuery.solution("A", Array(0), Array(0))
    assert(res.toList == List(1))
  }
}
