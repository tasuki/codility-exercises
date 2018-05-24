import org.scalatest._

class PolishTest extends FlatSpec with Matchers {
  it should "" in {
    assert(Polish.calc("5 2 + 3 *") == 21)
  }
  it should "" in {
    assert(Polish.calc("5 2 * 2 * 4 +") == 24)
  }
  it should "" in {
    assert(Polish.calc("5") == 5)
  }
  it should "" in {
    assert(Polish.calc("0 1 *") == 0)
  }
}
