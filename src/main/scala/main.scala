import game.Game

object Main extends App {
  val deck1 = new deck.Deck
  val deck2 = new deck.Deck

  deck1.autofill()
  deck2.autofill()

  val playerOne = new Player(deck1)
  val playerTwo = new Player(deck2)

  val game1 = new game.Game(playerOne, playerTwo)

  val hand1 = game1.playerOne.hand
  val hand2 = game1.playerTwo.hand

  game1.gameLoop
}