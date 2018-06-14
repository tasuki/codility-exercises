package _10

object MinPerimeterRectangle {
  def cartesianProduct[T](lst: List[List[T]]): List[List[T]] = {
    def pel(e: T,
      ll: List[List[T]],
      a: List[List[T]] = Nil): List[List[T]] =
      ll match {
        case Nil => a.reverse
        case x :: xs => pel(e, xs, (e :: x) :: a )
      }

    lst match {
      case Nil => Nil
      case x :: Nil => List(x)
      case x :: _ =>
        x match {
          case Nil => Nil
          case _ =>
            lst.par.foldRight(List(x))( (l, a) =>
              l.flatMap(pel(_, a))
            ).map(_.dropRight(x.size))
        }
    }
  }

  def generateFactors(primeFactors: List[(Int, Int)]): List[Int] = {
    val values = List(1) :: primeFactors.map {
      case (factor, exp) =>
        (0 to exp).map(e => BigInt(factor).pow(e).toInt).toList
    }

    cartesianProduct(values).map(_.product).sorted
  }

  def getSides(factors: List[Int]): (Int, Int) = {
    val i = factors.length / 2

    if (factors.length % 2 == 0)
      (factors(i - 1), factors(i))
    else
      (factors(i), factors(i))
  }

  def solution(n: Int): Int = {
    val primeFactors = CountFactors.primeFactors(n).groupBy(identity).mapValues(_.length).toList
    val factors = generateFactors(primeFactors)

    val (a, b) = getSides(factors)
    2 * a + 2 * b
  }
}
