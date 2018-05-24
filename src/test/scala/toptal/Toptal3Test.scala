package toptal

import org.scalatest.FlatSpec

class Toptal3Test extends FlatSpec {
  it should "split into 2 for 2 1 4 3" in {
    assert(Toptal3.solution(Seq(2, 1, 4, 3)) == 2)
  }
}