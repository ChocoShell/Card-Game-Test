import org.scalatest._
import scalaz._
import Scalaz._
import deck.Deck

class DeckSpec extends FlatSpec with Matchers {

  "A deck" should "contain 30 cards" in {
    val deckMaker = new Deck
    deckMaker.autofill()
    val deck = deckMaker.decklist
    assert(deck.length == 30)
  }

  it should "not contain 5 or more of the same card" in {
    val deckMaker = new Deck
    deckMaker.autofill()
    val deck = deckMaker.decklist
    val tooMany = deck.groupBy(card => card.id).exists(card => card._2.length > 5)
    assert(tooMany == false)

  }

}
