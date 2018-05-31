package _04

import org.scalatest.FlatSpec

class FrogRiverOneTest extends FlatSpec {
  it should "jump over in 6 seconds" in {
    assert(FrogRiverOne.solution(5, Array(1, 3, 1, 4, 2, 3, 5, 4)) == 6)
  }
}
