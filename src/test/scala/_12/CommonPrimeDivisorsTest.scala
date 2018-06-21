package _12

import scala.util.Random

import org.scalatest.FlatSpec

class CommonPrimeDivisorsTest extends FlatSpec {
  it should "work for sample case" in {
    assert(CommonPrimeDivisors.solution(Array(15, 10, 3), Array(75, 30, 5)) == 1)
  }

  it should "find common prime factors for 15 and 75" in {
    assert(CommonPrimeDivisors.hasSamePrimeFactors(15, 75) == true)
  }

  it should "not find common prime factors for 5 and 7" in {
    assert(CommonPrimeDivisors.hasSamePrimeFactors(5, 7) == false)
  }

  it should "not find common prime factors for 15 and 30" in {
    // 3 * 5 vs 3 * 5 * 2
    assert(CommonPrimeDivisors.hasSamePrimeFactors(15, 30) == false)
  }

  it should "work for 1 1" in {
    assert(CommonPrimeDivisors.hasSamePrimeFactors(1, 1) == true)
  }

  it should "work for 5 5" in {
    assert(CommonPrimeDivisors.hasSamePrimeFactors(5, 5) == true)
  }

  it should "be fast" in {
    CommonPrimeDivisors.solution(
      Array.fill(10000)(Random.nextInt(1000)),
      Array.fill(10000)(Random.nextInt(1000))
    )
  }
}
