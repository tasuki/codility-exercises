package _07

import org.scalatest.FlatSpec

class BracketsTest extends FlatSpec {
  it should "be balanced for sample case" in {
    assert(Brackets.solution("{[()()]}") == 1)
  }

  it should "not be balanced for sample case" in {
    assert(Brackets.solution("([)()]") == 0)
  }

  it should "be balanced for empty" in {
    assert(Brackets.solution("") == 1)
  }
}
