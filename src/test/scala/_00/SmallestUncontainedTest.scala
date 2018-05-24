package _00

import org.scalatest._

class SmallestUncontainedTest extends FlatSpec with Matchers {
  it should "work for missing number" in {
    assert(SmallestUncontained.solution(Array(1, 3, 6, 4, 1, 2)) == 5)
  }   

  it should "work for next number" in {
    assert(SmallestUncontained.solution(Array(1, 2, 3)) == 4)
  }   

  it should "work with negative numbers" in {
    assert(SmallestUncontained.solution(Array(-1, -3)) == 1)
  }   
}