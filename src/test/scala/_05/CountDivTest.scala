package _05

import org.scalatest.FlatSpec

class CountDivTest extends FlatSpec {
  it should "work" in {
    assert(CountDiv.solution(6, 11, 2) == 3)
  }

  it should "work with one more" in {
    assert(CountDiv.solution(6, 12, 2) == 4)
  }

  it should "also work" in {
    assert(CountDiv.solution(5, 11, 2) == 3)
  }

  it should "work with nothing inbetween" in {
    assert(CountDiv.solution(100, 101, 3) == 0)
  }

  it should "work with large k" in {
    assert(CountDiv.solution(6, 11, 30) == 0)
  }

  it should "work for another sample" in {
    assert(CountDiv.solution(100, 123456789, 2) == 61728345)
  }
}
