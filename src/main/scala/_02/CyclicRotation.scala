package _02

object CyclicRotation {
  def solution(a: Array[Int], k: Int): Array[Int] = {
    val len = a.length
    val split =
      if (len > 0) len - k % a.length
      else 0
    val append = a.slice(0, split)
    val prepend = a.slice(split, len)
    prepend ++ append
  }
}
