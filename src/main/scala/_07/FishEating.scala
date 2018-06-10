package _07

import scala.annotation.tailrec

case class Fish(size: Int, upstream: Boolean)
object Fish {
  def fromInts(size: Int, upstream: Int): Fish =
    Fish(size, upstream == 0)
}

object FishEating {
  def eat(downSwimming: List[Fish], up: Fish): List[Fish] =
    downSwimming.dropWhile(_.size < up.size)

  @tailrec
  def swim(downSwimming: List[Fish], upSwam: Int, fish: List[Fish]): Int = {
    fish match {
      case next :: rest if next.upstream =>
        val downEaten = eat(downSwimming, next)
        val upSuccess = if (downEaten.isEmpty) 1 else 0
        swim(downEaten, upSwam + upSuccess, rest)
      case next :: rest =>
        swim(next :: downSwimming, upSwam, rest)
      case Nil =>
        downSwimming.length + upSwam
    }
  }

  def solution(a: Array[Int], b: Array[Int]): Int = {
    val fishList = (a zip b).map((Fish.fromInts _).tupled).toList
    swim(List.empty[Fish], 0, fishList)
  }
}
