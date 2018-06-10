package _07

object Brackets {
  def closes(token: Char, stack: List[Char]): Boolean = {
    val headIs = stack.headOption.contains _
    token match {
      case '}' => headIs('{')
      case ']' => headIs('[')
      case ')' => headIs('(')
    }
  }

  def isBalanced(stack: List[Char], tokens: List[Char]): Boolean =
    tokens match {
      case Nil => stack.isEmpty
      case token :: tailTokens =>
        token match {
          case t if Seq('{', '[', '(').contains(t) =>
            isBalanced(t :: stack, tailTokens)
          case t =>
            if (closes(t, stack))
              isBalanced(stack.tail, tailTokens)
            else
              false
        }
    }

  def solution(expr: String): Int =
    isBalanced(List.empty[Char], expr.toList) match {
      case true => 1
      case false => 0
    }
}
