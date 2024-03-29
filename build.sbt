name         := "fc_bts"
organization := "com.fc.bts"
version      := "1.0"
scalaVersion := "2.11.5"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

libraryDependencies ++= Seq(
  jdbc,
  anorm,
  cache,
  ws,
  filters
)

libraryDependencies ++= Seq(
  "com.typesafe.slick" %% "slick"      % "2.1.0",
  "org.postgresql"     %  "postgresql" % "9.3-1102-jdbc41"
)
