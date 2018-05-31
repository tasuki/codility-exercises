package _04

object FrogRiverOne {
  val infinity = 1000000
  def solution(x: Int, a: Array[Int]): Int = {
    val reachableTime = Array.fill(x)(infinity)

    for ((pl, time) <- a.zipWithIndex) {
      val place = pl - 1
      if (time < reachableTime(place)) {
        reachableTime(place) = time
      }
    }

    reachableTime.max match {
      case x if x == infinity => -1
      case x => x
    }
  }
}
