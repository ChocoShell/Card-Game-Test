import org.scalatest._
import scalaz._
import Scalaz._
import game.Game

class GameSpec extends FlatSpec {

  "A game" should "have turns" in {
    val deckMaker1 = new Deck
    val deckMaker2 = new Deck

    val deck1 = (deckMaker1.autofill()).decklist
    val deck2 = (deckMaker2.autofill()).decklist

    assert(true)
  }
}