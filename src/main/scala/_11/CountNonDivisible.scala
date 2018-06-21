package _11

object CountNonDivisible {
  def divisors(a: Array[Int]): Array[Int] = {
    val upTo = a.max + 1
    val divisors = Array.fill(upTo)(0)

    a.sorted.foreach { i =>
      (i until upTo by i).foreach(divisors(_) += 1)
    }

    divisors
  }

  def solution(a: Array[Int]): Array[Int] = {
    val divs = divisors(a)
    a.map(x => a.length - divs(x))
  }
}
