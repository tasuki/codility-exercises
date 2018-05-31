package _04

import _03.PermMissingElem

object MissingInteger {
  def solution(a: Array[Int]): Int = {
    val candidates = a.sorted.filter(_ > 0)
    PermMissingElem.solution(candidates)
  }
}
