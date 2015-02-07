package game

import deck.Deck
import player.Player

class Game(deckOne : Deck, deckTwo : Deck) {
  val rnd = new scala.util.Random
  var currentTurn = rnd.nextInt(2)

  // Put into a Player Class?
  val playerOneDeck = deckOne
  deckOne.start
  var playerOneLife = 20
  var playerOneHand = deckOne.drawN(3)

  val playerTwoDeck = deckTwo 
  deckTwo.start
  var playerTwoLife = 20
  var playerTwoHand = deckTwo.drawN(3)  

  var newPlayer = new Player(deckOne)

  def gameLoop = {
    // 100 total turns - 1 turn for testing
    var i = 0
    for(i <- 1 to 2) {
      playerOneHand = playerOneHand :+ deckOne.draw
      println("Current Hand of Player One")
      playerOneHand foreach println
    }
  }
  /*
  start game function 
  - Decide who goes first - Already decided up top.
  - game loop
    - Player 1 Turn
      - Give Mana
      - Reset Mana
      - Draw card for Player
      - Give Control to Player
        - Player plays cards
        - Player attacks
        - Player Ends Turn
      - Turn ends due to Timer
    - Player 2 Turn
    - If Life Total is 0 or less that player loses.
  */

  
}