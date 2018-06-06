package _06

import scala.annotation.tailrec

trait BorderKind
case object Start extends BorderKind
case object End extends BorderKind

case class Border(kind: BorderKind, at: Int, disc: Int)

object NumberOfDiscIntersections {
  def getExtremes(arr: List[Int], op: (Int, Int) => Int): List[Int] =
    arr.zipWithIndex.map(_.swap).map(op.tupled)

  def getOrderedBorders(
    arr: List[Int],
    kind: BorderKind
  ): List[Border] = {
    val builder: (Int, Int) => Border = Border.apply(kind, _, _)
    arr.zipWithIndex.map(builder.tupled).sortBy(_.at)
  }

  def merge(b1: List[Border], b2: List[Border]): List[Border] =
    (b1 ++ b2).sortBy(b => (b.at, b.kind == End))

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
