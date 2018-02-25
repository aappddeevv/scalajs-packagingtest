// 1.0.0-M3 or 0.6.22 by default
val scalaJSVersion =
  Option(System.getenv("SCALAJS_VERSION")).getOrElse("0.6.22")

addSbtPlugin("org.scala-js" % "sbt-scalajs" % scalaJSVersion)
addSbtPlugin("com.lucidchart" % "sbt-scalafmt" % "1.14")
