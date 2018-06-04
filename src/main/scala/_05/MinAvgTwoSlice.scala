package _05

object MinAvgTwoSlice {
  def solution(arr: Array[Int]): Int = {
    var mindex: Int = 0
    var minAvg: Double = 1000000

    for (a <- List.range(0, arr.length - 1)) {
      val potential = Seq(arr.slice(a, a + 2), arr.slice(a, a + 3))
        .filter(_.length > 1)
        .map(arr => (arr.sum.toDouble / arr.length))
        .min

      if (potential < minAvg) {
        minAvg = potential
        mindex = a
      }
    }

    mindex
  }
}
