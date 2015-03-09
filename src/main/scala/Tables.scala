import scala.slick.driver.H2Driver.simple._
import scala.slick.lifted.{ProvenShape, ForeignKeyQuery}

// A Card Table with 9 columns: id, name, cost, power, health, 
//  effect, type, subtype, setid
class Cards(tag: Tag)
  extends Table[(Int, String, Int, Int, Int, 
                 String, String, String, String )](tag, "cards") {
  
  // Primary Key
  def id: Column[Int] = column[Int]("id", O.PrimaryKey)
  def name: Column[String] = column[String]("name")
  def cost: Column[Int] = column[Int]("cost")
  def power: Column[Int] = column[Int]("power")
  def health: Column[Int] = column[Int]("health")
  def effect: Column[String] = column[String]("effect")
  def cardtype: Column[String] = column[String]("cardtype")
  def tribe: Column[String] = column[String]("tribe")
  def setid: Column[String] = column[String]("setid")

  // For * queries
  def * : ProvenShape[(Int, String, Int, Int, Int, 
                 String, String, String, String)] =
    (id, name, cost, power, health, effect, cardtype, tribe, setid)
}
