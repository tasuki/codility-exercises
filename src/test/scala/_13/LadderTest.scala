package _13

import org.scalatest.FlatSpec

class LadderTest extends FlatSpec {
  it should "work for sample case" in {
    assert(Ladder.solution(
      Array(4, 4, 5, 5, 1),
      Array(3, 2, 4, 3, 1)
    ).toList == List(5, 1, 8, 0, 1))
  }
}
