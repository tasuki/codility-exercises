package _10

import scala.annotation.tailrec
import scala.collection.JavaConverters._

object Flags {
  def isPeak(left: Int, self: Int, right: Int): Boolean =
    self > left && self > right

  def isPeak(hills: Array[Int], index: Int): Boolean =
    isPeak(hills(index - 1), hills(index), hills(index + 1))

  def findPeaks(hills: Array[Int]): Seq[Boolean] = {
    (0 to hills.length - 1).map { index =>
      if (hills.isDefinedAt(index - 1) && hills.isDefinedAt(index + 1))
        isPeak(hills, index)
      else false
    }
  }

  def findNextPeak(peaks: Seq[Boolean], from: Int): Option[Int] = {
    val index = peaks.drop(from).indexOf(true)
    if (index >= 0) Some(from + index) else None
  }

  @tailrec
  def flagsFit(peaks: Seq[Boolean], numOfFlags: Int, putFlags: Int = 0): Boolean = {
    if (putFlags == numOfFlags) true
    else findNextPeak(peaks, numOfFlags) match {
      case Some(peak) =>
        flagsFit(peaks.drop(peak), numOfFlags, putFlags + 1)
      case None =>
        putFlags == numOfFlags
    }
  }

  def solution(hills: Array[Int]): Int = {
    val padding = Array.fill[Boolean](hills.length/2)(false)
    val peaks = padding ++ findPeaks(hills) ++ padding

    for (numOfFlags <- (1 to hills.length))
      if (!flagsFit(peaks, numOfFlags))
        return numOfFlags - 1

    throw new Exception("oops")
  }
}
