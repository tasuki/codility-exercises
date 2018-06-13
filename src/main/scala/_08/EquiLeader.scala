package _08

import scala.annotation.tailrec

object EquiLeader {
  @tailrec
  def countEquiLeaders(
    lst: List[Int],
    leader: Int,
    leftSize: Int,
    leftLeaders: Int,
    rightSize: Int,
    rightLeaders: Int,
    equiLeaders: Int = 0
  ): Int = lst match {
    case h :: t =>
      val newEqui =
        if (leftLeaders > leftSize / 2 && rightLeaders > rightSize / 2) equiLeaders + 1
        else equiLeaders

      val (newLeft, newRight) =
        if (h == leader) (leftLeaders + 1, rightLeaders - 1)
        else (leftLeaders, rightLeaders)

      countEquiLeaders(t, leader, leftSize + 1, newLeft, rightSize - 1, newRight, newEqui)
    case Nil =>
      equiLeaders
  }

  def solution(a: Array[Int]): Int = {
    val lst = a.toList
    val leader = Dominator.findPotentialLeader(lst)
    val leaderCount = lst.filter(_ == leader).length
    countEquiLeaders(lst, leader, 0, 0, lst.length, leaderCount)
  }
}
