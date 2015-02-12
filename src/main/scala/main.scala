import game.Game

import deck.Deck
import player.Player
import turn.Turn

object Main extends App {
  val deck1 = new Deck
  val deck2 = new Deck

  deck1.autofill()
  deck2.autofill()

  val playerOne = new Player(deck1)
  val playerTwo = new Player(deck2)
  val game1 = new Game(playerOne, playerTwo, Turn.turnCLI)

  game1.gameLoop
}