package _11

import org.scalatest.FlatSpec

class CountSemiprimesTest extends FlatSpec {
  it should "find primes" in {
    val primes = List(2, 3, 5, 7, 11, 13, 17, 19, 23, 29)
    val primeVector = (0 to 30).map(primes.contains).toVector

    assert(CountSemiprimes.eratosthenes(30) == primes)
  }

  it should "convert list to bools" in {
    assert(CountSemiprimes.inListBools(List(2, 3, 5)) == Vector(
      false, false, true, true, false, true
    ))
  }

  it should "work for sample case" in {
    assert(CountSemiprimes.solution(
      26,
      Array( 1,  4, 16),
      Array(26, 10, 20)
    ).toList == List(10, 4, 0))
  }
}
