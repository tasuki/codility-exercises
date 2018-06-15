package _10

import scala.util.Random
import org.scalatest.FlatSpec

class PeaksTest extends FlatSpec {
  it should "work for sample case" in {
    assert(Peaks.solution(Array(1, 2, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2)) == 3)
  }

  it should "work for 4 peaks" in {
    assert(Peaks.solution(Array(1, 2, 3, 2, 1, 2, 1, 2, 1, 2, 1, 1)) == 4)
  }

  it should "work for grouped peaks" in {
    assert(Peaks.solution(Array(1, 2, 1, 2, 1, 1, 1, 1, 1, 1, 2, 1)) == 2)
  }

  it should "extreme min" in {
    assert(Peaks.solution(Array(5)) == 0)
  }

  it should "without peaks" in {
    assert(Peaks.solution(Array(1, 1, 1, 1, 1)) == 0)
  }

  it should "be fast for large input" in {
    Peaks.solution(Array.fill(1000000)(1000).map(Random.nextInt))
  }
}
