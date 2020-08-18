package uk.gov.hmrc.test.api.cucumber.stepdefs

import io.cucumber.scala.{ScalaDsl, Scenario}
import uk.gov.hmrc.test.api.utils.ApiLogger.log
import uk.gov.hmrc.test.api.utils.ScenarioContext

class BaseHooks extends ScalaDsl {

  Before { scenario: Scenario =>
    log.info("Removing scenario context for scenario: " + scenario.getName)
    ScenarioContext.reset()
  }
}