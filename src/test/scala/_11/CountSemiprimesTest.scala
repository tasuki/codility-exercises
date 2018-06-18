package _11

import org.scalatest.FlatSpec

class CountSemiprimesTest extends FlatSpec {
  it should "find primes" in {
    val primes = List(2, 3, 5, 7, 11, 13, 17, 19, 23, 29)
    val primeVector = (0 to 30).map(primes.contains).toVector

    assert(CountSemiprimes.eratosthenes(30) == primes)
  }

  it should "convert list to sums" in {
    assert(CountSemiprimes.prefixSum(List(2, 3, 5), 6) == Vector(
      0, 0, 1, 2, 2, 3, 3
    ))
  }

  it should "work for sample case" in {
    assert(CountSemiprimes.solution(
      26,
      Array( 1,  4, 16),
      Array(26, 10, 20)
    ).toList == List(10, 4, 0))
  }

  it should "be fast for large case" in {
    CountSemiprimes.solution(
      50000,
      (1 to 25000).toArray,
      (25000 to 50000).toArray
    )
  }
}
