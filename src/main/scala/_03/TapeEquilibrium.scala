package _03

object TapeEquilibrium {
  def solution(arr: Array[Int]): Int = {
    var bestScore: Int = 1000000
    var left: Int = arr(0)
    var right: Int = arr.slice(1, arr.length).sum

    for (i <- 1 to arr.length - 1) {
      val potentialScore = (left - right).abs
      if (potentialScore < bestScore)
        bestScore = potentialScore

      left += arr(i)
      right -= arr(i)
    }

    bestScore
  }
}
