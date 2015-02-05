package deck

import card.Card

class Deck {
  // Has 30 cards for now
  var decklist = List[Card]()
  def autofill() = 
    for(x <- decklist.length until 30)
      decklist = decklist :+ new Card(x, "Counter", "", 1, 1)

  val rnd = new scala.util.Random
  
  def draw(cards: Int = 1) = {
    if(cards == 0) {

    } else {
      val id = rnd.nextInt(30)
      decklist = remove(decklist(id), decklist)
      draw(cards - 1)
    }
  }
}