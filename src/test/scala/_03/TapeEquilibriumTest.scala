package _03

import org.scalatest.FlatSpec

class TapeEquilibriumTest extends FlatSpec {
  it should "find equilibrium for official sample" in {
    assert(TapeEquilibrium.solution(Array(3, 1, 2, 4, 3)) == 1)
  }

  it should "find equilibrium with lotsa ones" in {
    assert(TapeEquilibrium.solution(Array(1, 1, 1, 1, 1, 4)) == 1)
  }

  it should "find equilibrium with couple fewer ones" in {
    assert(TapeEquilibrium.solution(Array(1, 1, 1, 1, 4)) == 0)
  }

  it should "negative numbers" in {
    assert(TapeEquilibrium.solution(Array(-100, 100)) == 200)
  }

  it should "all negative numbers" in {
    assert(TapeEquilibrium.solution(Array(-10, -5, -3, -4, -5)) == 3)
  }

  it should "tricky" in {
    assert(TapeEquilibrium.solution(Array(-10, -20, -30, -40, 100)) == 20)
  }

  it should "ones" in {
    assert(TapeEquilibrium.solution(Array(1, 1, 1, 1, 1, -1, -1, -1)) == 0)
  }

  it should "more ones" in {
    assert(TapeEquilibrium.solution(Array(1, 1, 1, 1, -1, -1, -1)) == 1)
  }

  it should "reverted ones" in {
    assert(TapeEquilibrium.solution(Array(-1, -1, -1, 1, 1, 1, 1)) == 1)
  }
}
