import AssemblyKeys._ //一番最初の行に書く

assemblySettings

name:= """SlickSample2"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  //jdbc,
  cache,
  ws,
  "org.scalatestplus.play" %% "scalatestplus-play" % "1.5.1" % Test
)

resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"

libraryDependencies += "com.typesafe.play" % "play-slick_2.11" % "2.0.2"
libraryDependencies += "com.typesafe.play" % "play-slick-evolutions_2.11" % "2.0.2"
libraryDependencies += "org.webjars" % "webjars-play_2.11" % "2.5.0-2"
libraryDependencies += "com.typesafe.slick" % "slick-codegen_2.11" % "3.1.1"



