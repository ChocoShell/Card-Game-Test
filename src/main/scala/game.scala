package game

import player.Player

class Game(playerOne : Deck, playerTwo : Deck) {
  var currentTurn = rnd.nextInt(2)

  def gameLoop = {
    // 100 total turns - 1 turn for testing
    var i = 0
    for(i <- 1 to 2) {
      playerOne.hand = playerOne.hand :+ playerOne.myDeck.draw
      println("Current Hand of Player One")
      playerOne.hand foreach println
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