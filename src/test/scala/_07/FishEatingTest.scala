package _07

import org.scalatest.FlatSpec

class FishEatingTest extends FlatSpec {
  it should "work for the sample case" in {
    assert(FishEating.solution(Array(4, 3, 2, 1, 5), Array(0, 1, 0, 0, 0)) == 2)
  }

  it should "large fish should clear way" in {
    assert(FishEating.solution(Array(4, 1, 5, 2, 3), Array(0, 1, 1, 0, 0)) == 3)
  }
}
