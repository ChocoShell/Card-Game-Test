package player

import deck.Deck

class Player(dDeck : Deck) {
  val rnd = new scala.util.Random
  var pDeck = dDeck.decklist
  var life : Int = 20
  
  def draw : card.Card = {
    def remove(num: card.Card, list: List[card.Card]) = 
      list diff List(num)

    val id = rnd.nextInt(pDeck.length)
    val drawCard = pDeck(id)

    pDeck = remove(drawCard, pDeck)
    drawCard
  }

  def drawN(cards: Int = 1): List[card.Card] =
    if(cards > 1)
      List(draw) ::: drawN(cards - 1)
    else
      List(draw)

  var hand = drawN(3)  
}