import org.scalatest._
import scalaz._
import Scalaz._
import game.Game
import deck.Deck

class GameSpec extends FlatSpec {

  "A game" should "give both players 3 cards" in {
    val deck1 = new deck.Deck
    val deck2 = new deck.Deck

    deck1.autofill()
    deck2.autofill()

    val testgame = new game.Game(deck1, deck2)

    val hand1 = testgame.playerOneHand
    val hand2 = testgame.playerTwoHand

    assert(hand1.length == 3)
    assert(hand1.length == hand2.length)
  }
}