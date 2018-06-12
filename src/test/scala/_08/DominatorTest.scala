package _08

import org.scalatest.FlatSpec

class DominatorTest extends FlatSpec {
  it should "work for sample case" in {
    assert(Dominator.solution(Array(3, 4, 3, 2, 3, -1, 3, 3)) == 0)
  }

  it should "work for empty case" in {
    assert(Dominator.solution(Array()) == -1)
  }

  it should "work for another case" in {
    assert(Dominator.solution(Array(0, 0, 1, 1, 1)) == 2)
  }
}
