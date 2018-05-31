package _04

import org.scalatest.FlatSpec

class MissingIntegerTest extends FlatSpec {
  it should "find five" in {
    assert(MissingInteger.solution(Array(1, 3, 6, 4, 1, 2)) == 5)
  }

  it should "find 4" in {
    assert(MissingInteger.solution(Array(1, 2, 3)) == 4)
  }

  it should "find 1" in {
    assert(MissingInteger.solution(Array(-1, -3)) == 1)
  }
}
