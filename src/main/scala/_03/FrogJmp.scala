package _03

object FrogJmp {
  def solution(position: Int, destination: Int, jump: Int): Int =
    ((destination - position) / jump.toDouble).ceil.toInt
}
