package game

import deck.Deck

class Game(deckOne : Deck, deckTwo : Deck) {
  val playerOneDeck = deckOne
  val playerTwoDeck = deckTwo
  val rnd = new scala.util.Random
  var currentTurn = rnd.nextInt(2)
  var playerOneHand = deckOne.draw(3)
  var playerTwoHand = deckTwo.draw(3)
  if(currentTurn == 0) {
    playerOneTurn
    currentTurn = 1
  } else {
    playerTwoTurn
    currentTurn = 0
  }
}