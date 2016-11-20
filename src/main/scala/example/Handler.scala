/**
  * Lifted from https://github.com/neil-rubens/aws-lambda-scala-api-gateway
  */
package example
import scala.beans.BeanProperty

case class Request(
                    @BeanProperty var firstName: String,
                    @BeanProperty var lastName: String
                  ){
  /**
    * Empty constructor needed by jackson (for AWS Lambda)
    * @return
    */
  def this() = this(firstName = "", lastName = "")

}

case class Response(@BeanProperty var details: String){
  /**
    * Empty constructor needed by jackson (for AWS Lambda)
    * @return
    */
  def this() = this(details = "")

}

import com.amazonaws.services.lambda.runtime.{Context, RequestHandler}

class Handler extends RequestHandler[Request,Response]{
  override def handleRequest(input: Request, context: Context): Response = {
    Response("hello there: " + input.firstName + " " + input.lastName )
  }
}
