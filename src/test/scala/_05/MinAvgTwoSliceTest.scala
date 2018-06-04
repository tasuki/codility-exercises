package _05

import org.scalatest.FlatSpec

class MinAvgTwoSliceTest extends FlatSpec {
  it should "work for sample" in {
    assert(MinAvgTwoSlice.solution(Array(4, 2, 2, 5, 1, 5, 8)) == 1)
  }

  it should "work for other test" in {
    assert(MinAvgTwoSlice.solution(Array(9, 9, 1, 9, 9, 2, 3, 9)) == 5)
  }

  it should "work for yet other test" in {
    assert(MinAvgTwoSlice.solution(Array(9, 9, 3, 4, 1, 4, 1, 9)) == 4)
  }
}
