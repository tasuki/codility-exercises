package _11

import org.scalatest.FlatSpec

class CountNonDivisibleTest extends FlatSpec {
  it should "work for sample case" in {
    val res = CountNonDivisible.solution(Array(3, 1, 2, 3, 6)).toList
    assert(res == List(2, 4, 3, 2, 0))
  }
}
