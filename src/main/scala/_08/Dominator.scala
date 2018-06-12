package _08

import scala.annotation.tailrec

object Dominator {
  @tailrec
  def findPotentialLeader(a: List[Int], leader: Int = 0, count: Int = 0): Int =
    a match {
      case h :: t if count == 0 =>
        findPotentialLeader(t, h, 1)
      case h :: t if h == leader =>
        findPotentialLeader(t, leader, count + 1)
      case h :: t =>
        findPotentialLeader(t, leader, count - 1)
      case Nil =>
        leader
    }

  def isLeader(a: List[Int], leader: Int): Boolean =
    a.filter(_ == leader).length > a.length / 2

  def solution(a: Array[Int]): Int = {
    val lst = a.toList
    val leader = findPotentialLeader(lst)

    if (isLeader(lst, leader))
      lst.indexOf(leader)
    else
      -1
  }
}
