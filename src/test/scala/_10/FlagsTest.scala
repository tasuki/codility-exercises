package _10

import org.scalatest._

class FlagsTest extends FlatSpec with Matchers {
  it should "find 3 flags for sample" in {
    assert(Flags.solution(Array(1, 5, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2)) == 3)
  }   
}