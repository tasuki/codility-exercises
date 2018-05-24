package toptal

import org.scalatest.FlatSpec

class Toptal2Test extends FlatSpec {
  it should "filter for greater than" in {
    val x = Toptal2.filter(Array(29, 35, 50), 34)
    assert(x.length == 2)
  }

  it should "work for simple case" in {
    assert(Toptal2.solution(Array(29, 50), Array(61, 37), Array(37, 70)) == 3)
  }

  it should "work when there are two options every time" in {
    assert(Toptal2.solution(Array(29, 29), Array(61, 61), Array(70, 70)) == 8)
  }

  it should "work when there's no choice" in {
    assert(Toptal2.solution(Array(5), Array(5), Array(5)) == 0)
  }
}
