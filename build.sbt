name := """TheLocationTracker"""

version := "1.0-SNAPSHOT"

lazy val myProject = (project in file("."))
  .enablePlugins(PlayJava, PlayEbean)

scalaVersion := "2.11.11"

libraryDependencies += jdbc
libraryDependencies += javaJdbc
libraryDependencies += cache
libraryDependencies += javaWs

