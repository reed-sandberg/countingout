// countingout project root

lazy val root = (project in file(".")).
  settings(
    organization := "sandberg.reed",
    name := "countingout",
    version := "1.01",
    scalaVersion := "2.11.8",
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.0" % "test",
    logBuffered in Test := false
  )
