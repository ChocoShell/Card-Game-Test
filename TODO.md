# Card Game Demo

Card Game Demo is a bare bones example of things that go into a card game.  Taking inspiration from Magic and Hearthstone as a template.

  - Randomizer for card packs
  - RNG for in game events (Possibly?)
  - Card Class to keep track of current card stats, damage, etc.
  - Game Class
  - Player Class
  - User Class

### Card Packs

Card Packs Section needs a RNG to determine the frequency at which cards show up in packs dependent on rarity and total number of cards in collection.
  - Probability of card showing up is different for each rarity
  - Probability of cards of the same rarity dependent on how many cards of the same rarity there are.
  - Cards should have a minimum rarity requirement (at least 1 higher rarity card)
  - Card Packs will have five cards and four different rarities.  In the future, this will be generalized to multiple values.

### Random Events(?)
- Skipping until later

### Game Class
A game class keeps track of the current game state:
- Keep track of the field(creatures, buffs, etc).
- Game modes
- CLI should be moved into a separate class.

### Player Class
Holds information about:
- Deck
- Life
- Hand
- Discard Pile

### User Class
- Decks
- User Card Collection
- User stats(win-loss, MMR)

### Deck Class
- List of cards in deck.
- Possibly follows rules like only 4 of a certain card or a minimum of X cards in deck.
