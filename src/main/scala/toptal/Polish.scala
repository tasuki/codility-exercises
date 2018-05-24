trait Token
case object Plus extends Token
case object Times extends Token
case class Number(int: Int) extends Token

object Polish {
  def calc(str: String): Int = {
    val tokens: Seq[Token] = str.split(' ').map { _ match {
      case "*" => Times
      case "+" => Plus
      case n => Number(n.toInt)
    } }

    var a: Int = 0
    var b: Int = 0
    for (token <- tokens) {
    }
    3
  }
}
