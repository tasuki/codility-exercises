package _07

import org.scalatest.FlatSpec

class StoneWallTest extends FlatSpec {
  it should "work for sample case" in {
    assert(StoneWall.solution(Array(8, 8, 5, 7, 9, 8, 7, 4, 8)) == 7)
  }

  it should "work for one wall case" in {
    assert(StoneWall.solution(Array(8)) == 1)
  }

  it should "work for longer one height wall case" in {
    assert(StoneWall.solution(Array(8, 8, 8, 8)) == 1)
  }

  it should "work for decreasing case" in {
    assert(StoneWall.solution(Array(8, 8, 5)) == 2)
  }

  it should "work for increasing case" in {
    assert(StoneWall.solution(Array(5, 8, 8)) == 2)
  }

  it should "work for three different heights" in {
    assert(StoneWall.solution(Array(5, 8, 6)) == 3)
  }

  it should "work for other three different heights" in {
    assert(StoneWall.solution(Array(5, 8, 4)) == 3)
  }
}
