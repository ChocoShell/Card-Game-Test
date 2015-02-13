package turn

import player.Player
import card.Card

object Turn {
  // CLI Function
  /*
  start game function 
  - Decide who goes first - Already decided up top.
  - game loop
    - Player 1 Turn
      + Give Mana
      + Reset Mana
      + Draw card for Player
      + Give Control to Player
        + Player plays cards
        - Player attacks
        - Player Ends Turn
      - Turn ends due to Timer
    - Player 2 Turn
    - If Life Total is 0 or less that player loses.
  */
  def turnCLI(guy : Player, otherGuy : Player) : Unit = {
    // Print Card Details to Screen
    def details(that : Card) : String = {
      var allDetails = "\nName: " + that.name + "\n"
      allDetails = allDetails + "Effect: " + that.effect + "\n"
      allDetails = allDetails + "Power: " + that.power + "\n"
      allDetails = allDetails + "Health: " + that.health + "\n"
      allDetails = allDetails + "Cost: " + that.cost + "\n"
      allDetails
    }

    def attack(one : Player, two : Player) : Unit = {
      for(monster <- one.field) {two.life -= monster.power}
      print("Defending player left with: ")
      println(two.life)
    }

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
        }
        case "field" => guy.field foreach println
        case "end" => println("Ending Turn")
        case "help" => println("end, hand, field, attack")
        case "attack" => attack(guy, otherGuy)
        case _ => println("Invalid Command, type 'help'")
      }
    }
  }  
}