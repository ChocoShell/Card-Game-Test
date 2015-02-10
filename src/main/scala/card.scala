package card

class Card(did: Int, dname: String, deffect: String, dpower: Int, dhealth: Int, dcost: Int) {
  val id = did
  val name = dname 
  val effect = deffect
  val power = dpower
  val health = dhealth
  val cost = dcost

  override def toString : String = name

  def details : String = {
    var allDetails = "\nName: " + name + "\n"
    allDetails = allDetails + "Effect: " + effect + "\n"
    allDetails = allDetails + "Power: " + power + "\n"
    allDetails = allDetails + "Health: " + health + "\n"
    allDetails = allDetails + "Cost: " + cost + "\n"
    allDetails
  }
}