package _10

import org.scalatest.FlatSpec

class CountFactorsTest extends FlatSpec {
  it should "work for the sample case" in {
    // 1 2 3 4 6 8 12 24
    assert(CountFactors.solution(24) == 8)
  }

  it should "work for 1 damn" in {
    // 1!
    assert(CountFactors.solution(1) == 1)
  }

  it should "work for 2" in {
    // 1 2
    assert(CountFactors.solution(2) == 2)
  }

  it should "work for 49" in {
    // 1 7 49
    assert(CountFactors.solution(49) == 3)
  }

  it should "work for 13" in {
    // 1 13
    assert(CountFactors.solution(13) == 2)
  }
  it should "work for 75" in {
    // 1 3 5 15 25 75
    assert(CountFactors.solution(75) == 6)
  }

  it should "work for 45" in {
    // 1 3 5 9 15 45
    assert(CountFactors.solution(45) == 6)
  }

  it should "work for 32" in {
    // 1 2 4 8 16 32
    assert(CountFactors.solution(32) == 6)
  }

  it should "be fast for a large prime" in {
    // large prime
    assert(CountFactors.solution(780291637) == 2)
  }
}
