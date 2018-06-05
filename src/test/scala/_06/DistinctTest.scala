package _06

import org.scalatest.FlatSpec

class DistinctTest extends FlatSpec {
  it should "count distinct" in {
    assert(Distinct.solution(Array(2, 1, 1, 2, 3, 1)) == 3)
  }
}
