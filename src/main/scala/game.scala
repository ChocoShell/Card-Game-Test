package game

import player.Player

class Game(dPlayerOne : Player, dPlayerTwo : Player) {
  val playerOne = dPlayerOne
  val playerTwo = dPlayerTwo

  val rnd = new scala.util.Random
  var currentTurn = rnd.nextInt(2)

  // CLI Function
  def details(that : Card) : String = {
    var allDetails = "\nName: " + that.name + "\n"
    allDetails = allDetails + "Effect: " + that.effect + "\n"
    allDetails = allDetails + "Power: " + that.power + "\n"
    allDetails = allDetails + "Health: " + that.health + "\n"
    allDetails = allDetails + "Cost: " + that.cost + "\n"
    allDetails
  }

  def gameLoop = {
    // 100 total turns - 1 turn for testing
    var i = 0
    playerOne.start
    playerTwo.start
    for(i <- 1 to 1) {
      // Start Turn
      playerOne.mana += 1
      // Draw Phase
      playerOne.hand = playerOne.hand :+ playerOne.draw
      // Player Can Do Stuff
      // Picking card loop/function
      // Main Phase
      def turn(guy : Player) = {
        // CLI testing stuff
        var in = ""
        while(in != "end") {

          // Output
          println("What would you like to do?")
          
          // User Input
          in = Console.readLine()

          // Dependent Output
          in match {
            case "hand" => {
              println("Current Hand:")
              guy.hand foreach println
              println
              // Pick card to play stuff goes here
            }
            case "field" => guy.showField
            case "end" => println("Ending Turn")
            case "help" => println("end, or hand")
            case _ => println("Invalid Command, type 'help'")
          }
        }
        // Output
        println("\nPick a Card to Play: ")
        // Input
        val something = Console.readLine()
        // Understanding Input
        val selCard = guy.hand(something.toInt - 1)

        // Dependent Output
        println(details(selCard))
        println("\nPlay This Card? ")  

        // Input
        val playcard = Console.readLine()

        // Input dependent Output
        playcard match {
          case "yes" => guy.play(selCard)
          case "no" => println("Ok")
        }

        guy.field foreach println
        // End of CLI
      }
      turn(playerOne)
      // Combat Phase
      // End Phase
      // End Turn
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