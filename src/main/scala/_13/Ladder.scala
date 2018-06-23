package _13

import scala.annotation.tailrec

object Ladder {
  @tailrec
  def fibonacci(count: Int, acc: List[BigInt]): List[BigInt] = {
    if (count < 1) acc.reverse
    else fibonacci(count - 1, acc.head + acc.tail.head :: acc)
  }

  def solution(a: Array[Int], b: Array[Int]): Array[Int] = {
    val fib = fibonacci(50000, List(1, 1)).toArray

    (a zip b)
      .map { case (aa, bb) => fib(aa) % BigInt(2).pow(bb) }
      .map(_.toInt)
  }
}
