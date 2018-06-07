package toptal

import org.scalatest.FlatSpec

class Toptal3Test extends FlatSpec {
  it should "find 0 loop" in {
    assert(Toptal3.findLoop(Vector(0, 1, 3, 2), 0) == Seq(0))
  }
  it should "find 01 loop" in {
    assert(Toptal3.findLoop(Vector(1, 0, 3, 2), 0) == Seq(0, 1))
  }
  it should "find 23 loop" in {
    assert(Toptal3.findLoop(Vector(1, 0, 3, 2), 2) == Seq(2, 3))
  }
  it should "find 0123 loop" in {
    assert(Toptal3.findLoop(Vector(1, 3, 0, 2), 2) == Seq(0, 1, 2, 3))
  }

  it should "find loops" in {
    assert(Toptal3.findLoops(Vector(0, 1, 3, 2)) == Seq(Seq(0), Seq(1), Seq(2, 3)))
  }
  it should "find more loops" in {
    assert(Toptal3.findLoops(Vector(2, 1, 0, 3)) == Seq(Seq(0, 2), Seq(1), Seq(3)))
  }
  it should "find sorted loops" in {
    assert(Toptal3.findLoops(Vector(2, 3, 0, 1)) == Seq(Seq(0, 2), Seq(1, 3)))
  }

  it should "split into 2 for 2143" in {
    assert(Toptal3.solution(Vector(2, 1, 4, 3)) == 2)
  }

  it should "split into 1 for 2413" in {
    assert(Toptal3.solution(Vector(2, 4, 1, 3)) == 1)
  }

  it should "split into 3" in {
    assert(Toptal3.solution(Vector(1, 2, 4, 3)) == 3)
  }

  it should "split into 1" in {
    assert(Toptal3.solution(Vector(4, 1, 2, 3)) == 1)
  }

  it should "split into 2 for 3214" in {
    assert(Toptal3.solution(Vector(3, 2, 1, 4)) == 2)
  }

  it should "split into 1 when three circles: 13, 24, 56" in {
    assert(Toptal3.solution(Vector(3, 5, 1, 6, 2, 4)) == 1)
  }

  it should "split into 4" in {
    assert(Toptal3.solution(Vector(1, 3, 2, 4, 6, 5)) == 4)
  }

  it should "split into 1 when 6 and lower" in {
    assert(Toptal3.solution(Vector(6, 1, 2, 3, 4, 5)) == 1)
  }
}
