package _02

object OddOccurrencesInArray {
  def solution(a: Array[Int]): Int =
    a.groupBy(identity)
      .map { case (i, arr) => (i, arr.length) }
      .filter { case (i, l) => l % 2 == 1 }
      .toSeq.head._1
}
