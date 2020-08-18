import sbt.Resolver

name := "$name$"

version := "0.1.0"

scalaVersion := "2.12.11"

scalacOptions ++= Seq("-unchecked", "-deprecation", "-feature")

resolvers += "hmrc-releases" at "https://artefacts.tax.service.gov.uk/artifactory/hmrc-releases/"
resolvers += Resolver.bintrayRepo("hmrc", "releases")

lazy val testSuite = (project in file("."))
  .disablePlugins(JUnitXmlReportPlugin) //Required to prevent https://github.com/scalatest/scalatest/issues/1427

libraryDependencies ++= Seq(
  "org.scalatest"              %% "scalatest"               % "3.0.7" % "test",
  "io.cucumber"                %% "cucumber-scala"          % "6.1.1" % "test",
  "io.cucumber"                %  "cucumber-junit"          % "6.1.1" % "test",
  "junit"                      %  "junit"                   % "4.12"  % "test",
  "com.novocode"               %  "junit-interface"         % "0.11"  % "test",
  "com.typesafe"               %  "config"                  % "1.3.2",
  "com.typesafe.play"          %% "play-ahc-ws-standalone"  % "2.1.2",
  "org.slf4j"                  % "slf4j-simple"             % "1.7.25"
)
