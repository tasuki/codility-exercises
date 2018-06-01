package _04

import org.scalatest.FlatSpec

class MaxCountersTest extends FlatSpec {
  it should "work" in {
    val lst = MaxCounters.solution(5, Array(3, 4, 4, 6, 1, 4, 4)).toList
    assert(lst == List(3, 2, 2, 4, 2))
  }
}
