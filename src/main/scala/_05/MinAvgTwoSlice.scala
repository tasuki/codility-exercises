package _05

import scala.annotation.tailrec

object MinAvgTwoSlice {
  @tailrec
  def findSlice(
    arr: List[Int],
    curindex: Int = 0,
    mindex: Int = 0,
    minAvg: Double = 1000000
  ): Int =
    arr match {
      case _ :: t => {
        val potential = Seq(arr.slice(0, 2), arr.slice(0, 3))
          .filter(_.length > 1)
          .map(x => (x.sum.toDouble / x.length))
          .reduceOption(_ min _)

        potential match {
          case Some(p) if p < minAvg =>
            findSlice(t, curindex + 1, curindex, p)
          case _ =>
            findSlice(t, curindex + 1, mindex, minAvg)
        }
      }
      case Nil => mindex
    }

  def solution(arr: Array[Int]): Int =
    findSlice(arr.toList)
}
