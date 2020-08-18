package uk.gov.hmrc.test.api.client

import akka.actor.ActorSystem
import play.api.libs.ws.DefaultBodyWritables._
import play.api.libs.ws.ahc.StandaloneAhcWSClient

import scala.concurrent.{ExecutionContext, Future}

class HttpClient {

  implicit val actorSystem: ActorSystem = ActorSystem()
  val wsClient = StandaloneAhcWSClient()
  implicit val ec: ExecutionContext = ExecutionContext.global

  def GET(url: String, headers: (String, String)*): Future[ServiceResponse] =
    wsClient
      .url(url)
      .withHttpHeaders(headers: _*)
      .get
      .map(response => ServiceResponse(response.status, Option(response.headers), Option(response.body)))

  def POST(url: String, bodyAsJson: String, headers: (String, String)*): Future[ServiceResponse] =
    wsClient
      .url(url)
      .withHttpHeaders(headers: _*)
      .post(bodyAsJson)
      .map(response => ServiceResponse(response.status, Option(response.headers), Option(response.body)))

  def DELETE(url: String, headers: (String, String)*): Future[ServiceResponse] =
    wsClient
      .url(url)
      .withHttpHeaders(headers: _*)
      .delete
      .map(response => ServiceResponse(response.status, Option(response.headers), Option(response.body)))
}

case class ServiceResponse(status: Int, headers: Option[Map[String, Seq[String]]], body: Option[String])
