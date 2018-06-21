package _12

import org.scalatest.FlatSpec

class CommonPrimeDivisorsTest extends FlatSpec {
  it should "work for sample case" in {
    assert(CommonPrimeDivisors.solution(Array(15, 10, 3), Array(75, 30, 5)) == 1)
  }

  it should "find common prime factors for 15 and 75" in {
    assert(CommonPrimeDivisors.commonPrimeDivisors(15, 75) == true)
  }

  it should "not find common prime factors for 5 and 7" in {
    assert(CommonPrimeDivisors.commonPrimeDivisors(5, 7) == false)
  }
}
