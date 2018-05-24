package toptal.extended

import org.scalatest._

class PolishExtendedTest extends FlatSpec with Matchers {
  it should "sum to 21" in {
    assert(Polish.calc("5 2 + 3 *") == 21)
  }

  it should "sum to 24" in {
    assert(Polish.calc("5 2 * 2 * 4 +") == 24)
  }

  it should "sum to 5" in {
    assert(Polish.calc("5") == 5)
  }

  it should "sum to 0" in {
    assert(Polish.calc("0 1 *") == 0)
  }

  it should "sum to 84" in {
    assert(Polish.calc("5 2 2 2 * 2 * 4 +") == 84)
  }
}
