package card

class Card(did: Int, dname: String, deffect: String, dpower: Int, dhealth: Int, dcost: Int) {
  val id = did
  val name = dname 
  val effect = deffect
  val power = dpower
  val health = dhealth
  val cost = dcost

  override def toString : String = name
}