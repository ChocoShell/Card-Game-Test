package turn

import player.Player
import card.Card

object Turn {
  // CLI Function
  def turnCLI(guy : Player) : Unit = {
    // Print Card Details to Screen
    def details(that : Card) : String = {
      var allDetails = "\nName: " + that.name + "\n"
      allDetails = allDetails + "Effect: " + that.effect + "\n"
      allDetails = allDetails + "Power: " + that.power + "\n"
      allDetails = allDetails + "Health: " + that.health + "\n"
      allDetails = allDetails + "Cost: " + that.cost + "\n"
      allDetails
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
        }
        case "field" => guy.field foreach println
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
  }  
}