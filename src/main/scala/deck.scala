package deck

import card.Card

class Deck {
  // Has 30 cards for now
  var decklist = List[Card]()
  def autofill() = 
    for(x <- decklist.length until 30)
      decklist = decklist :+ new Card(x, "Counter", "", 1, 1)

  val rnd = new scala.util.Random
  def remove(num: card.Card, list: List[card.Card]) = list diff List(num)

  def draw : card.Card = {
    val id = rnd.nextInt(decklist.length)
    val drawCard = decklist(id)
    decklist = remove(drawCard, decklist)
    drawCard
  }

  def drawN(cards: Int = 1): List[card.Card] = {
    if(cards > 1) {
      List(draw) ::: drawN(cards - 1)
    } else {
      List(draw)
    }

  }
}