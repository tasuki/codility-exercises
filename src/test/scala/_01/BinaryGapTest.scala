package _01

import org.scalatest._

class BinaryGapTest extends FlatSpec with Matchers {
  it should "find 5 for 1041" in {
    assert(BinaryGap.solution(1041) == 5)
  }   

  it should "find 0 for 15" in {
    assert(BinaryGap.solution(15) == 0)
  }   
}
