package _05

object CountDiv {
  def solution(a: Int, b: Int, k: Int): Int = {
    val first = k * (a / k.toFloat).ceil.toInt
    val last = k * (b / k.toFloat).floor.toInt

    if (first > last) 0
    else 1 + (last - first) / k
  }
}
