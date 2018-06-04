package _05

import scala.math.BigDecimal.RoundingMode

object CountDiv {
  def solution(a: Int, b: Int, k: Int): Int = {
    val first = k * (BigDecimal(a) / k).setScale(0, RoundingMode.CEILING).toInt
    val last = k * (BigDecimal(b) / k).setScale(0, RoundingMode.FLOOR).toInt

    if (first > last) 0
    else 1 + (last - first) / k
  }
}
