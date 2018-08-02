package _13

import scala.annotation.tailrec

object FibFrog {
  @tailrec
  def fibonacci(acc: List[Int]): List[Int] = {
    if (acc.head > 100000) acc
    else fibonacci(acc.head + acc.tail.head :: acc)
  }

  def countJumps(
    leaves: Array[Int],
    fib: Array[Int],
    n: Int,
    position: Int,
    jumps: Int
  ): Option[Int] = {
    val fibs = fib.dropWhile(_ > n - position)
    if (fibs.head == n - position) Some(jumps)
    else {
      val jumpable = fibs.filter(f => leaves(position + f) == 1)

      jumpable.flatMap { jump =>
        countJumps(leaves, fib, n, position + jump, jumps + 1)
      }.reduceOption(_ min _)
    }
  }

  def solution(leaves: Array[Int]): Int = {
    val fib = fibonacci(List(1, 1)).toArray

    countJumps(leaves, fib, leaves.length, -1, 1)
      .getOrElse(-1)
  }
}
