package _03

import org.scalatest.FlatSpec

class FrogJmpTest extends FlatSpec {
  it should "jump" in {
    assert(FrogJmp.solution(10, 85, 30) == 3)
  }

  it should "jump just right" in {
    assert(FrogJmp.solution(0, 100, 10) == 10)
  }

  it should "jump once more" in {
    assert(FrogJmp.solution(0, 101, 10) == 11)
  }
}
