import org.scalatest._
import scalaz._
import Scalaz._
import cardPackGen.Card_Pack_Gen

class CardPackSpec extends FlatSpec with Matchers {

  "Card pack generator" should "generate card rarities at specific values" in {
    val gen = new Card_Pack_Gen
    var total = gen.generate().groupBy(x => x).map(x => (x._1, x._2.length))
    val test_num = 1000
    for(x <- 1 until test_num) {
      val current = gen.generate().groupBy(x => x).map(x => (x._1, x._2.length))
      total = total |+| current
    }
    val totals = total.values.sum.toFloat
    for(i <- total) {
      i._1 match {
        case "Common" => i._2 should be (5*70*test_num/100 +- 5*5*test_num/100)
        case "Rare" => i._2 should be (5*22*test_num/100 +- 5*5*test_num/100)
        case "Epic" => i._2 should be (5*5*test_num/100 +- 5*3*test_num/100)
        case "Legendary" => i._2 should be (5*2*test_num/100 +- 5*2*test_num/100)
      }
    }
  }
}