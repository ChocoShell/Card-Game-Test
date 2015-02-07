package player

import deck.Deck

class Player(dDeck : Deck) {
  var myDeck = dDeck
  var life : Int = 20
  var hand = dDeck.drawN(3)
  println(myDeck.length)
}