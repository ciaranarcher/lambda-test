package example

case class NameInfo(firstName: String, lastName: String)

class Main {
  import java.io.{InputStream, OutputStream}

  def greeting(input: InputStream, output: OutputStream): Unit = {
    import org.json4s._
    import org.json4s.jackson._
    implicit val formats = DefaultFormats

    val json = parseJson(scala.io.Source.fromInputStream(input).mkString)

    // Use http://json4s.org/ to read into the case class
    val name = json.extract[NameInfo]

    val result = s"Greetings ${name.firstName} ${name.lastName}."
    output.write(result.getBytes("UTF-8"))
  }
}
