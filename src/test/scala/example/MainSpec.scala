import org.scalatest._

class MainSpec extends FlatSpec with Matchers {

  val input = """{
      "firstName": "Ciaran",
      "lastName": "Archer"
    }"""

  import java.io.{ByteArrayInputStream, ByteArrayOutputStream}
  val in = new ByteArrayInputStream(input.getBytes)
  val out = new ByteArrayOutputStream()

  val subject = new example.Main()

  it should "take an input steam and decode it to JSON" in {
    subject.greeting(in, out)
    out.toString should equal("Greetings Ciaran Archer.")
  }
}
