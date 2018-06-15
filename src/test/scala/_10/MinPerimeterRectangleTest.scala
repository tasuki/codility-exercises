package _10

import org.scalatest.FlatSpec

class MinPerimeterRectangleTest extends FlatSpec {
  it should "work for sample case" in {
    // 1 2 3 5 6 10 15 30
    assert(MinPerimeterRectangle.solution(30) == 22)
  }

  it should "work for 1" in {
    assert(MinPerimeterRectangle.solution(1) == 4)
  }

  it should "work for 13" in {
    assert(MinPerimeterRectangle.solution(13) == 28)
  }

  it should "work for 32" in {
    // 1 2 4 8 16 32
    assert(MinPerimeterRectangle.solution(32) == 24)
  }

  it should "work for 180" in {
    // 1, 2, 3, 4, 5, 6, 9, 10, 12, 15, 18, 20, 30, 36, 45, 60, 90, 180
    // 2 * 12 + 2 * 15
    assert(MinPerimeterRectangle.solution(180) == 54)
  }
}
