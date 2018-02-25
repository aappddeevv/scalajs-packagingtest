// Build file for ReasonRect like scala.js reactjs bindings.
// Now that's a mouthful...
import scala.sys.process._

lazy val buildSettings = Seq(
  organization := "ttg",
  licenses ++= Seq(("MIT", url("http://opensource.org/licenses/MIT"))),
  scalaVersion := "2.12.4",
  resolvers += Resolver.sonatypeRepo("releases"),
  resolvers += Resolver.jcenterRepo,
  scalafmtVersion in ThisBuild := "1.4.0",
  autoCompilerPlugins := true
)

val commonScalacOptions = Seq(
    "-deprecation",
    "-encoding", "UTF-8",
    "-feature",
    "-language:_",
  "-unchecked",
    "-Yno-adapted-args",
    "-Ywarn-numeric-widen",
    "-Xfuture",
  "-Ypartial-unification",
  )

lazy val commonSettings = Seq(
  scalacOptions ++= commonScalacOptions ++
        (if (scalaJSVersion.startsWith("0.6."))
      Seq("-P:scalajs:sjsDefinedByDefault")
        else Nil),
  scalaJSLinkerConfig ~= { _.withModuleKind(ModuleKind.CommonJSModule) },
  libraryDependencies ++= Seq(
    "org.scala-js" %%% "scalajs-dom" % "latest.version"),
)

lazy val libsettings = buildSettings ++ commonSettings

lazy val root = project.in(file("."))
  .settings(libsettings)
  .settings(name := "scalajs-packagingtest")
  .aggregate(
    test0,
    test1, test2, test3,
    test4, test5, test6,
    test7, test8, test9,
    test10)
  .enablePlugins(ScalaJSPlugin)

lazy val test0 = project
  .settings(libsettings)
  .enablePlugins(ScalaJSPlugin)
  .settings()

lazy val test1 = project
  .settings(libsettings)
  .enablePlugins(ScalaJSPlugin)
  .settings(
    scalaJSUseMainModuleInitializer := true,
    mainClass in Compile := Some("test1")
  )

lazy val test2 = project
  .settings(libsettings)
  .enablePlugins(ScalaJSPlugin)
  .settings(
    scalaJSUseMainModuleInitializer := true,
    mainClass in Compile := Some("test2")
  )

lazy val test3 = project
  .settings(libsettings)
  .enablePlugins(ScalaJSPlugin)
  .settings(
    scalaJSUseMainModuleInitializer := true,
    mainClass in Compile := Some("test3")
  )

lazy val test4 = project
  .settings(libsettings)
  .enablePlugins(ScalaJSPlugin)
  .settings(
    scalaJSUseMainModuleInitializer := true,
    mainClass in Compile := Some("test4")
  )

lazy val test5 = project
  .settings(libsettings)
  .enablePlugins(ScalaJSPlugin)
  .settings(
    scalaJSUseMainModuleInitializer := true,
    mainClass in Compile := Some("test5")
  )

lazy val test6 = project
  .settings(libsettings)
  .enablePlugins(ScalaJSPlugin)
  .settings(
    scalaJSUseMainModuleInitializer := true,
    mainClass in Compile := Some("test6")
  )

lazy val test7 = project
  .settings(libsettings)
  .enablePlugins(ScalaJSPlugin)
  .settings(
    scalaJSUseMainModuleInitializer := true,
    mainClass in Compile := Some("test7")
  )

lazy val test8 = project
  .settings(libsettings)
  .enablePlugins(ScalaJSPlugin)
  .settings(
    scalaJSUseMainModuleInitializer := true,
    mainClass in Compile := Some("test8")
  )


lazy val test9 = project
  .settings(libsettings)
  .enablePlugins(ScalaJSPlugin)
  .settings(
    scalaJSUseMainModuleInitializer := true,
    mainClass in Compile := Some("test9")
  )

lazy val test10 = project
  .settings(libsettings)
  .enablePlugins(ScalaJSPlugin)
  .settings()
