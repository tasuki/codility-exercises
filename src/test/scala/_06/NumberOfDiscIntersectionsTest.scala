package _06

import org.scalatest.FlatSpec

class NumberOfDiscIntersectionsTest extends FlatSpec {
  it should "sort discs by start" in {
    val order = NumberOfDiscIntersections.getOrderedBorders(
      List(-1, -4, 0, 2, 0, 5),
      Start
    )

    assert(order == List(
      Border(Start, -4, 1),
      Border(Start, -1, 0),
      Border(Start,  0, 2),
      Border(Start,  0, 4),
      Border(Start,  2, 3),
      Border(Start,  5, 5)
    ))
  }

  it should "merge starts and ends" in {
    val starts: List[Border] = List(
      Border(Start, -4, 1),
      Border(Start, -1, 0),
      Border(Start,  0, 2),
      Border(Start,  0, 4),
      Border(Start,  2, 3),
      Border(Start,  5, 5))

    val ends: List[Border] = List(
      Border(End, 1, 0),
      Border(End, 4, 2),
      Border(End, 4, 3),
      Border(End, 5, 5),
      Border(End, 6, 1),
      Border(End, 8, 4))

    val merged = NumberOfDiscIntersections.merge(starts, ends)

    assert(merged == List(
      Border(Start, -4, 1),
      Border(Start, -1, 0),
      Border(Start,  0, 2),
      Border(Start,  0, 4),
      Border(End,    1, 0),
      Border(Start,  2, 3),
      Border(End,    4, 2),
      Border(End,    4, 3),
      Border(Start,  5, 5),
      Border(End,    5, 5),
      Border(End,    6, 1),
      Border(End,    8, 4)
    ))
  }

  it should "count intersections for sample" in {
    assert(NumberOfDiscIntersections.solution(Array(1, 5, 2, 1, 4, 0)) == 11)
  }
}
