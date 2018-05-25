package _03

import org.scalatest._

class PermMissingElemTest extends FlatSpec with Matchers {
  it should "work for missing number" in {
    assert(PermMissingElem.solution(Array(1, 3, 6, 4, 1, 2)) == 5)
  }

  it should "work for next number" in {
    assert(PermMissingElem.solution(Array(1, 2, 3)) == 4)
  }

  it should "work with negative numbers" in {
    assert(PermMissingElem.solution(Array(-1, -3)) == 1)
  }
}
