package game

import player.Player

class Game(dPlayerOne : Player, dPlayerTwo : Player, turn: (Player, Player) => Unit) {
  val playerOne = dPlayerOne
  val playerTwo = dPlayerTwo

  val rnd = new scala.util.Random
  var currentTurn = rnd.nextInt(2)

  def gameLoop = {
    // 100 total turns - 2 turns for testing
    var i = 0
    playerOne.start
    playerTwo.start
    for(i <- 1 to 2) {
      if(currentTurn == 1) {
        turn(playerOne, playerTwo)
        currentTurn = 0
      } else if (currentTurn == 0) {
        turn(playerTwo, playerOne)
        currentTurn = 1
      }
    }
  }  
}