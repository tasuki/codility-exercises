package _02

import org.scalatest.FlatSpec

class CyclicRotationTest extends FlatSpec {
  it should "work for simple case" in {
    val solution = CyclicRotation.solution(Array(3, 8, 9, 7, 6), 3)
    println(solution.toSeq)
    assert(solution.sameElements(Array(9, 7, 6, 3, 8)))
  }

  it should "work for k > n" in {
    val solution = CyclicRotation.solution(Array(3, 8, 9, 7, 6), 13)
    println(solution.toSeq)
    assert(solution.sameElements(Array(9, 7, 6, 3, 8)))
  }

  it should "work for empty array" in {
    val solution = CyclicRotation.solution(Array(), 13)
    println(solution.toSeq)
    assert(solution.sameElements(Array[Int]()))
  }
}
