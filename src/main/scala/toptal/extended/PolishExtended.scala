package toptal.extended

trait Token
trait Op extends Token {
  def apply(ns: List[Number]): Number
}
case object Plus extends Op {
  def apply(ns: List[Number]): Number =
    ns.foldLeft(Number(0))((a, b) => Number(a.int + b.int))
}
case object Times extends Op {
  def apply(ns: List[Number]): Number =
    ns.foldLeft(Number(1))((a, b) => Number(a.int * b.int))
}
case class Number(int: Int) extends Token

object Polish {
  def calcExpr(nums: List[Number], c: List[Token]): Number = {
    c match {
      case Nil => nums.head
      case (n: Number) :: t => calcExpr(n :: nums, t)
      case (op: Op) :: t => calcExpr(List(op.apply(nums)), t)
    }
  }

  def calc(str: String): Int = {
    val tokens = str.split(' ').toList.map {
      case "*" => Times
      case "+" => Plus
      case n => Number(n.toInt)
    }

    tokens match {
      case (n: Number) :: t => calcExpr(List(n), t).int
    }
  }
}
