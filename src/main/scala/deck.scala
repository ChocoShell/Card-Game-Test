package deck

import card.Card

class Deck {
  // Has 30 cards for now
  // Full list of cards that doesn't change
  var decklist = List[Card]()

  // Current cards in deck
  var gamedeck = List[Card]()

  def autofill() = 
    for(x <- decklist.length until 30)
      decklist = decklist :+ new Card(x, "Counter"+x, "", 1, 1, 0)

  val rnd = new scala.util.Random
  def remove(num: card.Card, list: List[card.Card]) = list diff List(num)

  def start =
    gamedeck = decklist

  def draw : card.Card = {
    val id = rnd.nextInt(gamedeck.length)
    val drawCard = gamedeck(id)
    gamedeck = remove(drawCard, gamedeck)
    drawCard
  }

  def drawN(cards: Int = 1): List[card.Card] = {
    if(cards > 1) {
      List(draw) ::: drawN(cards - 1)
    } else {
      List(draw)
    }
  }

  def length = gamedeck.length
}