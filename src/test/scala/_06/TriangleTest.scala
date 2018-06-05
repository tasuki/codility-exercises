package _06

import org.scalatest.FlatSpec

class TriangleTest extends FlatSpec {
  it should "find triangle" in {
    assert(Triangle.solution(Array(10, 2, 5, 1, 8, 20)) == 1)
  }

  it should "not find triangle when there is none" in {
    assert(Triangle.solution(Array(10, 50, 5, 1)) == 0)
  }

  it should "find triangle when 3" in {
    assert(Triangle.solution(Array(3, 4, 5)) == 1)
  }

  it should "not find triangle when 2" in {
    assert(Triangle.solution(Array(3, 4)) == 0)
  }
}
