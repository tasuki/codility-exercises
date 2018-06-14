package _09

import org.scalatest.FlatSpec

class MaxDoubleSliceSumTest extends FlatSpec {
  it should "work for sample case" in {
    val res = MaxDoubleSliceSum.solution(Array(3, 2, 6, -1, 4, 5, -1, 2))
    assert(res == 17)
  }

  it should "work for 3 items" in {
    val res = MaxDoubleSliceSum.solution(Array(1, 2, 3))
    assert(res == 0)
  }
}
