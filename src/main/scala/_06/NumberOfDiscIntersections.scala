package _06

import scala.collection.mutable

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

  def countIntersections(borders: List[Border]): Int = {
    var open = 0
    var intersections = 0

    borders.foreach {
      case Border(Start, _, _) =>
        intersections += open
        open += 1
      case _ =>
        open -= 1
    }

    intersections
  }

  def solution(a: Array[Int]): Int = {
    val discs = a.toList
    val startOrder = getOrderedBorders(getExtremes(discs, _ - _), Start)
    val endOrder   = getOrderedBorders(getExtremes(discs, _ + _), End)

    countIntersections(merge(startOrder, endOrder))
  }
}
