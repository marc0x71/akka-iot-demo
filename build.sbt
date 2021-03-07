name := "akka-iot-demo"

version := "0.1"

scalaVersion := "2.13.5"

idePackagePrefix := Some("org.example")

val AkkaVersion = "2.6.13"
libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor-typed" % AkkaVersion,
  "com.typesafe.akka" %% "akka-actor-testkit-typed" % AkkaVersion % Test,
  "org.scalatest" %% "scalatest" % "latest.integration" % "test"
)
