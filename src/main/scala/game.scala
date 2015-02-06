package game

import deck.Deck

class Game(deckOne : Deck, deckTwo : Deck) {
  val rnd = new scala.util.Random
  var currentTurn = rnd.nextInt(2)

  // Put into Player Class?
  val playerOneDeck = deckOne
  val playerTwoDeck = deckTwo 
  var playerOneHand = deckOne.drawN(3)
  var playerTwoHand = deckTwo.drawN(3)
  var playerOneLife = 20
  var playerTwoLife = 20
  
  /*
  start game function 
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
    - Check life totals after each action

  */

  
}