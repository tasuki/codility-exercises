package toptal

// how many distinct paths if want to stop at A, B, C in order

object Toptal2 {

  def filter(sortedArr: Array[Int], greaterThan: Int): Array[Int] = {
    for (i <- 0 to sortedArr.length - 1) {
      if (sortedArr(i) > greaterThan)
        return sortedArr.slice(i, sortedArr.length)
    }

    Array()
  }

  def solution(a: Array[Int], b: Array[Int], c: Array[Int]): Int = {
    val aa = a.sorted
    val bb = b.sorted
    val cc = c.sorted

    var count: Int = 0

    // not the desired complexity :S
    // no time, sorry...
    for {
      aStop <- aa
      bStop <- filter(bb, aStop)
    } {
      count += filter(cc, bStop).length
    }

    count
  }
}
