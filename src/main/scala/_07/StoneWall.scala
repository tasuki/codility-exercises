package _07

import scala.collection.mutable

object StoneWall {
  def solution(a: Array[Int]): Int = {
    val stack = mutable.Stack.newBuilder[Int].result
    var blocks = 0

    for (height <- a) {
      while (stack.nonEmpty && height < stack.head) {
        stack.pop()
      }

      if (stack.isEmpty || height > stack.head) {
        stack.push(height)
        blocks += 1
      }
    }

    blocks
  }
}
