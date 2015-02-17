package game

import player.Player

class Game(dPlayerOne : Player, dPlayerTwo : Player, turn: (Player, Player) => Unit) {
  val playerOne = dPlayerOne
  val playerTwo = dPlayerTwo

  val rnd = new scala.util.Random
  var currentTurn = rnd.nextInt(2)

  def gameLoop = {
    // 100 total turns - 1 turn for testing
    var i = 0
    playerOne.start
    playerTwo.start
    for(i <- 1 to 1) {
      
      // Start Turn
      playerOne.mana += 1

      playerOne.aMana = playerOne.mana      
      
      // Draw Phase
      playerOne.hand = playerOne.hand :+ playerOne.draw
      
      // Player Can Do Stuff
      // Picking card loop/function
      // Main Phase
      turn(playerOne, playerTwo)
      // Combat Phase

      // End Phase
      // End Turn
    }
  }  
}