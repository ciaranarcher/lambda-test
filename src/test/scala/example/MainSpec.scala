import org.scalatest._

class MainSpec extends FlatSpec with Matchers {
  it should "take an input steam and decode it to JSON" in {
    val input = """{
      "firstName": "Ciaran",
      "lastName": "Archer"
    }"""

    import java.io.{ByteArrayInputStream, ByteArrayOutputStream}
    val in = new ByteArrayInputStream(input.getBytes)
    val out = new ByteArrayOutputStream()

    val subject = new example.Main()
    subject.greeting(in, out)

    assert("Greetings Ciaran Archer." == out.toString)
  }
}
