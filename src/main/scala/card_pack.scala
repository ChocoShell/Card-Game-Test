package cardPackGen

class Card_Pack_Gen {
  // Generate 5 cards with at least 1 rare card.
  // Chances of getting cards:
  // 4 commons, 1 rare
  // Common = 72
  // Rare = 22
  // Epic = 5
  // Legendary = 1
  val rnd = new scala.util.Random
  val common = 7405//87
  val rare = 2000//10
  val epic = 476//2
  val legendary = 119//1
  val common_range = 1 to (common + rare + epic + legendary)
  val rare_range = 1 to (rare + epic + legendary)

  def generate(): Array[String] = {
    var rarity_array: Array[String] = Array[String]()
    for(x <- 1 to 4) {
      val rarity_number = common_range(rnd.nextInt(common_range length));
      val rarity = rarity_number match {
        case x if x <= legendary => "Legendary"
        case x if x <= (legendary+epic) => "Epic"
        case x if x <= (legendary+epic+rare) => "Rare"
        case x if x <= (legendary+epic+rare+common)  => "Common"
        case _ => "Undefined"
      }
      rarity_array :+= rarity
    }
    val last_rarity = if(rarity_array.forall(_ == "Common")) rare_range(rnd.nextInt(rare_range length)) else common_range(rnd.nextInt(common_range length))
    val last_slot = last_rarity match {
      case x if x <= legendary => "Legendary"
      case x if x <= (legendary+epic) => "Epic"
      case x if x <= (legendary+epic+rare) => "Rare"
      case x if x <= (legendary+epic+rare+common)  => "Common"
      case _ => "Undefined"
    }
    rarity_array :+= last_slot
    rarity_array
  }
}