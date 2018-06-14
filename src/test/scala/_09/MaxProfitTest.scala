package _09

import org.scalatest.FlatSpec

class MaxProfitTest extends FlatSpec {
  it should "work for sample case" in {
    val profit = MaxProfit.solution(Array(23171, 21011, 21123, 21366, 21013, 21367))
    assert(profit == 356)
  }

  it should "work for empty case" in {
    val profit = MaxProfit.solution(Array())
    assert(profit == 0)
  }

  it should "work for one sample case" in {
    val profit = MaxProfit.solution(Array(123))
    assert(profit == 0)
  }
}
