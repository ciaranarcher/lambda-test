package example
import java.io.{InputStream, OutputStream}

import org.json4s.DefaultFormats
import org.json4s.jackson.parseJson

case class NameInfo(firstName: String, lastName: String)

class Main {

  def greeting(input: InputStream, output: OutputStream): Unit = {
    implicit val formats = DefaultFormats

    val json = parseJson(scala.io.Source.fromInputStream(input).mkString)

    val name = json.extract[NameInfo]

    val result = s"Greetings ${name.firstName} ${name.lastName}."
    output.write(result.getBytes("UTF-8"))
  }
}

