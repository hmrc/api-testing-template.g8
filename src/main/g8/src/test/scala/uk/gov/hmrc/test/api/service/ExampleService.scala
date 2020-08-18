package uk.gov.hmrc.test.api.service

import uk.gov.hmrc.test.api.client.{HttpClient, ServiceResponse}
import uk.gov.hmrc.test.api.conf.TestConfiguration

import scala.concurrent.Await
import scala.concurrent.duration._

class ExampleService(client: HttpClient) {
  val host: String = TestConfiguration.url("des")

  def getInformation(regime: String, idType: String, id: String): ServiceResponse = {
    val url = s"$host/cross-regime/customer/$regime/$idType/$id/information"
    def envHeader(env: String): (String, String) = ("Environment", env)
    Await.result(client.GET(url, ("Authorization", "Bearer EvYRlYH8AS_hZGw32ffqJ25Mz04a"), envHeader("ist0")), 10.seconds)
  }
}
