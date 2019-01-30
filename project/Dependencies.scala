import sbt._

object Dependencies {
  lazy val dependencies: Seq[ModuleID] = scalatest ++ scalacheck
  
  lazy val scalatest: Seq[ModuleID] = Seq(
    "org.scalatest" %% "scalatest" % "3.0.5" % "test, it"
  )

  lazy val scalacheck: Seq[ModuleID] = Seq(
    "org.scalacheck" %% "scalacheck" % "1.14.0" % "test, it"  
  )
}