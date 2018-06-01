package _04

// this is the ugliest fucking arbitrary task

object MaxCounters {
  def solution(n: Int, a: Array[Int]): Array[Int] = {
    val max = n
    var counters = Array.fill(n)(0)
    var curMaxCounter = 0

    for (i <- a) {
      if (i > n) {
        counters = Array.fill(n)(curMaxCounter)
      } else {
        val index = i - 1
        counters(index) += 1

        if (counters(index) > curMaxCounter) {
          curMaxCounter = counters(index)
        }
      }
    }

    counters
  }
}
