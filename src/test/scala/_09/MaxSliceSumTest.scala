package _09

import org.scalatest.FlatSpec

class MaxSliceSumTest extends FlatSpec {
  it should "work for sample case" in {
    assert(MaxSliceSum.solution(Array(3, 2, -6, 4, 0)) == 5)
  }

  it should "work for negative case" in {
    assert(MaxSliceSum.solution(Array(-10)) == -10)
  }

  it should "work for two element negative case" in {
    assert(MaxSliceSum.solution(Array(-10, -2)) == -2)
  }
}
