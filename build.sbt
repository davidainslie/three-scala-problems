import com.scalapenos.sbt.prompt.SbtPrompt.autoImport._
import Dependencies._
import sbt._

lazy val root = project("three-scala-problems", file("."))
  .settings(description := "Three Scala Problems")

def project(id: String, base: File): Project =
  Project(id, base)
    .settings(promptTheme := com.scalapenos.sbt.prompt.PromptThemes.ScalapenosTheme)
    .settings(
      resolvers ++= Seq(
        Resolver.sonatypeRepo("releases"),
        Resolver.sonatypeRepo("snapshots"),
        Resolver.bintrayRepo("cakesolutions", "maven"),
        "Artima Maven Repository" at "http://repo.artima.com/releases",
        "jitpack" at "https://jitpack.io"
      ),
      scalaVersion := BuildProperties("scala.version"),
      sbtVersion := BuildProperties("sbt.version"),
      organization := "com.backwards",
      name := id,
      addCompilerPlugin("org.spire-math" %% "kind-projector" % "0.9.9"),
      addCompilerPlugin("org.scalamacros" % "paradise" % "2.1.1" cross CrossVersion.full),
      libraryDependencies ++= dependencies,
      fork in Test := true,
      scalacOptions ++= Seq("-Ypartial-unification")
    )