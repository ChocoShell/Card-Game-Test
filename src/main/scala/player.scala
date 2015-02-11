package player

import deck.Deck
import card.Card

class Player(dDeck : Deck) {
  
  var life : Int;
  var mana : Int;
  var aMana : Int;
  var hand : List[Card];
  var pDeck : List[Card];
  var field : List[Card];
  
  def draw : Card = {
    val rnd = new scala.util.Random
    def remove(num: Card, list: List[Card]) = 
      list diff List(num)

    val id = rnd.nextInt(pDeck.length)
    val drawCard = pDeck(id)

    pDeck = remove(drawCard, pDeck)
    drawCard
  }

  def drawN(cards: Int = 1): List[Card] =
    if(cards > 1)
      List(draw) ::: drawN(cards - 1)
    else
      List(draw)

  // Called at game start
  // Sets up all values for player at game start
  def start = {
    pDeck = dDeck.decklist
    life = 20
    mana = 0
    aMana = 0
    hand = drawN(3)
    field = List[Card]()
  }

  def play(dCard : Card) = {
    aMana -= dCard.cost
    field = field :+ dCard
  }

  def showField = {
    println("Showing Field")
    field foreach println
  }
}