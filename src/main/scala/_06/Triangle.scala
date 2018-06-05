package _06

object Triangle {
  def isTriangle(a: Int, b: Int, c: Int): Boolean =
    a + b > c

  def solution(a: Array[Int]): Int = {
    val sorted = a.sorted

    for (i <- List.range(0, a.length - 2)) {
      if (isTriangle(sorted(i), sorted(i + 1), sorted(i + 2)))
        return 1
    }

    0
  }
}
