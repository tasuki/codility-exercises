package _06

import org.scalatest.FlatSpec

class MaxProductOfThreeTest extends FlatSpec {
  it should "work" in {
    assert(MaxProductOfThree.solution(Array(-3, 1, 2, -2, 5, 6)) == 60)
  }

  it should "work for one triple" in {
    assert(MaxProductOfThree.solution(Array(2, 3, 4)) == 24)
  }

  it should "work for a tricky case" in {
    assert(MaxProductOfThree.solution(Array(-5, 5, -5, 4)) == 125)
  }

  it should "work for a trickier case" in {
    assert(MaxProductOfThree.solution(Array(4, 5, 1, 0)) == 20)
  }

  it should "work for an even trickier case" in {
    assert(MaxProductOfThree.solution(Array(-10, -2, -4)) == -80)
  }

  it should "work for the trickiest case" in {
    assert(MaxProductOfThree.solution(Array(-2, -3, -5, -6, 0)) == 0)
  }

  it should "work for the trickier than trickiest case" in {
    assert(MaxProductOfThree.solution(Array(-5, -6, -4, -7, -10)) == -120)
  }
}
