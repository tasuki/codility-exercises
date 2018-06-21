package _12

import scala.annotation.tailrec

object ChocolatesByNumbers {
  @tailrec
  def gcd(a: BigInt, b: BigInt): BigInt =
    if (b == 0) a
    else gcd(b, a % b)

  def lcm(a: BigInt, b: BigInt): BigInt =
    a * b / gcd(a, b)

  def solution(n: Int, m: Int): Int =
    (lcm(n, m) / m).toInt
}
