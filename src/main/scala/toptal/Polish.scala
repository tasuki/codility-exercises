package toptal

trait Token
trait Op extends Token {
  def apply(a: Number, b: Number): Number
}
case object Plus extends Op {
  def apply(a: Number, b: Number) = Number(a.int + b.int)
}
case object Times extends Op {
  def apply(a: Number, b: Number) = Number(a.int * b.int)
}
case class Number(int: Int) extends Token

object Polish {
  def calcExpr(res: Number, c: Seq[Token]): Number = c match {
    case Nil => res
    case (n: Number) :: (op: Op) :: t => calcExpr(op.apply(res, n), t)
  }

  def calc(str: String): Int = {
    val tokens = str.split(' ').toList.map {
      case "*" => Times
      case "+" => Plus
      case n => Number(n.toInt)
    }

    tokens match {
      case (n: Number) :: t => calcExpr(n, t).int
    }
  }
}
