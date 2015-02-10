import org.scalatest._
import scalaz._
import Scalaz._
import game.Game
import deck.Deck
import player.Player

class GameSpec extends FlatSpec {

  "A game" should "give both players 3 cards" in {
    val deck1 = new Deck
    val deck2 = new Deck
    deck1.autofill()
    deck2.autofill()

    val playerOne = new Player(deck1)
    val playerTwo = new Player(deck2)

    val testgame = new Game(playerOne, playerTwo)

    val hand1 = testgame.playerOne.hand
    val hand2 = testgame.playerTwo.hand

    assert(hand1.length == 3)
    assert(hand1.length == hand2.length)
  }
}