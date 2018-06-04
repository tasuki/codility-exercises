package _06

object MaxProductOfThree {
  def solution(a: Array[Int]): Int = {
    val (positiveReversed, negative) = a.sorted.partition(_ >= 0)
    val positive = positiveReversed.reverse

    val negativeProduct =
      if (negative.length > 1)
        Some(negative(0) * negative(1))
      else
        None

    val positiveProduct =
      if (positive.length > 2)
        Some(positive(1) * positive(2))
      else
        None

    val biggerProduct = Seq(negativeProduct, positiveProduct).flatten.max
    // println(positive.toList, negative.toList)

    positive.headOption match {
      case Some(p) => p * biggerProduct
      case None => negative.reverse.take(3).reduce(_ * _)
    }
  }
}
