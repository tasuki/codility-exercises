package _12

import org.scalatest.FlatSpec

class ChocolatesByNumbersTest extends FlatSpec {
  it should "work for sample case" in {
    // 0 4 8 2 6
    // 2 2
    assert(ChocolatesByNumbers.solution(10, 4) == 5)
  }

  it should "work for 3" in {
    // 0 3 6 9 2 5 8 1 4 7
    // 3 3
    assert(ChocolatesByNumbers.solution(10, 3) == 10)
  }

  it should "work for 7" in {
    // 0 7 4 1 8 5 2 9 6 3
    // 1 10
    assert(ChocolatesByNumbers.solution(10, 7) == 10)
  }

  it should "work for 2" in {
    // 0 2 4 6 8
    // 4 1
    assert(ChocolatesByNumbers.solution(10, 2) == 5)
  }

  it should "work for 5" in {
    // 0 5
    // 1 1
    assert(ChocolatesByNumbers.solution(10, 5) == 2)
  }

  it should "work for 1" in {
    assert(ChocolatesByNumbers.solution(10, 1) == 10)
  }

  it should "large numbers" in {
    assert(ChocolatesByNumbers.solution(947853, 4453) == 947853)
  }
}
