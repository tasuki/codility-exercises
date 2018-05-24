package toptal

import scala.annotation.tailrec

// you're at 0,0
// get list of coordinates
// how many lasers have to shoot to hit all?

case class Point(x: Int, y: Int)

object Toptal1 {
  @tailrec
  def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b)

  def vector(p: Point): (Int, Int) = {
    val divisor = gcd(p.x, p.y).abs
    (p.x / divisor, p.y / divisor)
  }

  def solution(list: Seq[Point]): Int = {
    list.map(vector).distinct.length
  }
}
