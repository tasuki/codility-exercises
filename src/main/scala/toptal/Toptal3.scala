package toptal

import scala.annotation.tailrec

// get a list of integers: how many sublists can it be split into,
// so that when you sort each, the whole list is sorted

object Toptal3 {
  @tailrec
  def findLoop(
    arr: Vector[Int],
    startFrom: Int,
    ret: List[Int] = Nil
  ): List[Int] = {
    val newEl = arr(startFrom)

    if (ret.lastOption.contains(newEl)) ret.sorted
    else findLoop(arr, newEl, newEl :: ret)
  }

  @tailrec
  def findLoops(
    arr: Vector[Int],
    included: Vector[Boolean],
    loops: List[List[Int]] = Nil
  ): List[List[Int]] = {
    val startFrom = included.zipWithIndex
      .dropWhile(_._1).headOption.map(_._2)

    startFrom match {
      case None => loops.reverse
      case Some(start) =>
        val loop = findLoop(arr, start)
        val newIncl = included.zipWithIndex.map {
          case (incl, index) =>
            if (incl) true
            else loop.contains(index)
        }

        findLoops(arr, newIncl, loop :: loops)
    }
  }

  def findLoops(arr: Vector[Int]): List[List[Int]] =
    findLoops(arr, Vector.fill(arr.length)(false))

  def joinLoops(a: List[Int], b: List[Int]): List[Int] =
    (a ++ b).sorted // TODO inefficient

  def mergeConnectedLoops(loops: List[List[Int]]): List[List[Int]] = {
    loops match {
      case h1 :: h2 :: t =>
        if (h1.last > h2.head)
          mergeConnectedLoops(joinLoops(h1, h2) :: t)
        else
          h1 :: mergeConnectedLoops(h2 :: t)
      case single => single
    }
  }

  def solution(arr: Vector[Int]): Int = {
    val loops = findLoops(arr.map(_ - 1)).map(_.map(_ + 1))
    val connected = mergeConnectedLoops(loops)
    connected.length
  }
}
