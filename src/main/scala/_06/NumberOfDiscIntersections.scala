package _06

import scala.annotation.tailrec

trait BorderKind {
  val priority: Int
}
case object Start extends BorderKind {
  val priority = 1
}
case object End extends BorderKind {
  val priority = 2
}

case class Border(kind: BorderKind, at: Int, disc: Int)

object NumberOfDiscIntersections {
  def getExtremes(arr: List[Int], op: (Int, Int) => Int): List[Int] =
    arr.zipWithIndex.map {
      case (radius, center) => op(center, radius)
    }

  def getOrderedBorders(
    arr: List[Int],
    kind: BorderKind
  ): List[Border] = {
    val builder: (Int, Int) => Border = Border.apply(kind, _, _)
    arr.zipWithIndex.sortBy(_._1).map(builder.tupled)
  }

  def merge(b1: List[Border], b2: List[Border]): List[Border] =
    (b1 ++ b2).sortWith { (bx, by) =>
      if (bx.at < by.at) true
      else if (bx.at > by.at) false
      else bx.kind.priority < by.kind.priority
    }

  @tailrec
  def countIntersections(
    borders: List[Border],
    intersections: Int = 0,
    open: Int = 0
  ): Int = {
    borders match {
      case h :: t =>
        if (h.kind == Start)
          countIntersections(t, intersections + open, open + 1)
        else
          countIntersections(t, intersections, open - 1)
      case Nil => intersections
    }
  }

  def solution(a: Array[Int]): Int = {
    val discs = a.toList
    val startOrder = getOrderedBorders(getExtremes(discs, _ - _), Start)
    val endOrder   = getOrderedBorders(getExtremes(discs, _ + _), End)

    val count = countIntersections(merge(startOrder, endOrder))

    // yes please make it arbitrarily more difficult
    if (count > 10000000) -1 else count
  }
}
