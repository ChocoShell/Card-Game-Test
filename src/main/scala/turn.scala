package turn

import player.Player
import card.Card

/* Turns should let players:
    - Look at their:
      - Total Mana
      - Field
      - Life
    and those things of your opponent.
    - Players also see:
      - Hand
      - Available Mana
    - Play Cards From their hand
*/
// Turn functions allows users to interact with player and game objects.
object Turn {
 
  // CLI Function
  /*
    - Player 1 Turn
      + Give Mana
      + Reset Mana
      + Draw card for Player
      + Give Control to Player
        + Player plays cards
        + Player attacks
        + Player Ends Turn
      - Turn ends due to Timer
    + Player 2 Turn
    - If Life Total is 0 or less that player loses.
  */
  def turnCLI(guy : Player, otherGuy : Player) : Unit = {
    // Print Card Details to Screen
    def cardDetails(that : Card) : String = {
      var allDetails = "\nName: " + that.name + "\n"
      allDetails = allDetails + "Effect: " + that.effect + "\n"
      allDetails = allDetails + "Power: " + that.power + "\n"
      allDetails = allDetails + "Health: " + that.health + "\n"
      allDetails = allDetails + "Cost: " + that.cost + "\n"
      allDetails
    }

    def attack(one : Player, two : Player) : Unit = {
      println("Entering Attack Phase")
      for(monster <- one.field) {two.life -= monster.power}
      print("Defending player left with: ")
      println(two.life)
    }

    // Start Turn
    guy.mana += 1

    guy.aMana = guy.mana      
        
    // Draw Phase
    guy.hand = guy.hand :+ guy.draw
    
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
          if(guy.hand.isEmpty) {
            println("Hand is Empty")
          } else {
            println(guy.hand2String)

            // Pick card to play stuff goes here
            println("Pick a Card to Play: ")
            // Input
            val something = Console.readLine()

            // Understanding Input
            try { 
              val index = something.toInt
              val selCard = guy.hand(index - 1)
              // Dependent Output
              println(cardDetails(selCard))
              println("Play This Card? ")

               // Input
              val playcard = Console.readLine()

              // Input dependent Output
              playcard match {
                case "yes" => guy.play(selCard)
                case "no" => println("No card played.")
                case _ => println("Invalid command, no card played.")
              }

              guy.field foreach println   
            } catch {
              case nfe: NumberFormatException => println("Number Not Entered")
              case iobe: IndexOutOfBoundsException => println("Index Out of Bounds")
              case e: Exception => println("Some Error Occurred")
            }
          }
        }
        case "field" => guy.field foreach println
        case "end" => println("Ending Turn")
        case "help" => println("hand, field, mana, attack and end")
        case "mana" => {
          println("Total Mana: " + guy.mana + "\nAvailable Mana: " + guy.aMana)
          println("Opponent's Mana: " + otherGuy.mana)
        }
        case "life" => {
          println("Life: " + guy.life)
          println("Opponent's Life: " + otherGuy.life)
        }
        case "attack" => {
          attack(guy, otherGuy)
          in = "end"
        }
        case _ => println("Invalid Command, type 'help' for list of commands.")
      }
    }
  }  
}