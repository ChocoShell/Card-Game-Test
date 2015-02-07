import game.Game

object Main extends App {
  val deck1 = new deck.Deck
  val deck2 = new deck.Deck

  deck1.autofill()
  deck2.autofill()

  val game1 = new game.Game(deck1, deck2)

  val hand1 = game1.playerOneHand
  val hand2 = game1.playerTwoHand

  game1.gameLoop
}