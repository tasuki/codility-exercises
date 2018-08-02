package _13

import org.scalatest.FlatSpec

class FibFrogTest extends FlatSpec {
  it should "work for sample case" in {
    assert(FibFrog.solution(Array(0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0)) == 3)
  }

  it should "work for one jump" in {
    assert(FibFrog.solution(Array(0, 0, 0, 0)) == 1)
  }

  it should "work for impossible" in {
    assert(FibFrog.solution(Array(0, 0, 0, 0, 0)) == -1)
  }
}
