package _04

import org.scalatest.FlatSpec

class PermCheckTest extends FlatSpec {
  it should "return 1 when permutated" in {
    assert(PermCheck.solution(Array(4, 1, 2, 3)) == 1)
  }

  it should "return 0 when not permutated" in {
    assert(PermCheck.solution(Array(4, 1, 3)) == 0)
  }
}
