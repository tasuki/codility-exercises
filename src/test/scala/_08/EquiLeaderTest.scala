package _08

import org.scalatest.FlatSpec

class EquiLeaderTest extends FlatSpec {
  it should "work for sample case" in {
    assert(EquiLeader.solution(Array(4, 3, 4, 4, 4, 2)) == 2)
  }

  it should "work for empty" in {
    assert(EquiLeader.solution(Array()) == 0)
  }
}
