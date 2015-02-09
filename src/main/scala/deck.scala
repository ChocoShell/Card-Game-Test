package deck

import card.Card

class Deck {
  // Has 30 cards for now
  // Full list of cards that doesn't change
  var decklist = List[Card]()

  def autofill() = 
    for(x <- decklist.length until 30)
      decklist = decklist :+ new Card(x, "Counter"+x, "", 1, 1, 0)
}