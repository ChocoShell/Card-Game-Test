package game

import player.Player

class Game(dPlayerOne : Player, dPlayerTwo : Player) {
  val playerOne = dPlayerOne
  val playerTwo = dPlayerTwo
  

  val rnd = new scala.util.Random
  var currentTurn = rnd.nextInt(2)

  def gameLoop = {
    // 100 total turns - 1 turn for testing
    var i = 0
    for(i <- 1 to 1) {
      // Start Turn
      playerOne.mana += 1
      // Draw Phase
      playerOne.hand = playerOne.hand :+ playerOne.draw
      // Player Can Do Stuff
      // Picking card loop/function
      def turn(guy : Player) = {
        var in = ""
        while(in != "end") {
          println("What would you like to do?")
          var in = Console.readLine()
          in match {
            case "hand" => {
              println("Current Hand of Player One")
              guy.hand foreach println
              // Pick card to play stuff goes here
            }
            case "end" => println("Ending Turn")
            case "help" => println("end, or hand")
            case "_" => println("Invalid Command, type 'help'")
          }
        }
        
        println("Pick a Card to Play: ")
        val something = Console.readLine()
        println(guy.hand(something.toInt - 1).details)
        println("Play This Card? ")  
      }
      // Main Phase
      // Combat Phase
      // End Turn
      // Player turn
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