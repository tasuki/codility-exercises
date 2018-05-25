package _02

import org.scalatest.FlatSpec

class OddOccurrencesInArrayTest extends FlatSpec {
  it should "simple" in {
    assert(OddOccurrencesInArray.solution(Array(9, 3, 9, 3, 9, 7, 9)) == 7)
  }

}
