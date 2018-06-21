package toptal

import org.scalatest.FlatSpec

class Toptal1Test extends FlatSpec {
  it should "calculate gcd" in {
    assert(Toptal1.gcd(10, 15) == 5)
    assert(Toptal1.gcd(15, 10) == 5)
    assert(Toptal1.gcd(24, 12) == 12)
    assert(Toptal1.gcd(5, 3) == 1)
    assert(Toptal1.gcd(3, 5) == 1)
  }

  it should "work for simple case" in {
    assert(Toptal1.solution(Seq(
      Point( 1,  2),
      Point( 2,  4),
      Point(-1, -2),
      Point( 7,  4)
    )) == 3)
  }

  it should "work for another case" in {
    assert(Toptal1.solution(Seq(
      Point( 2,  2),
      Point( 8,  8),
      Point( 1, -1),
      Point(-1,  1),
      Point(-1, -1)
    )) == 4)
  }

  it should "work with zeroes" in {
    assert(Toptal1.solution(Seq(
      Point( 0,  1),
      Point( 1,  0),
      Point( 0, -1),
      Point(-1,  0)
    )) == 4)
  }
}
