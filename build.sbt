name := "scalajs-test"

version := "1.0.0"

scalaVersion := "2.11.6"

enablePlugins(ScalaJSPlugin)

libraryDependencies ++= Seq (
  // see: http://www.scala-js.org/doc/sbt/depending.html
  "org.scala-js" %%% "scalajs-dom" % "0.8.0",
  "com.lihaoyi" %%% "utest" % "0.3.0" % "test"
)

// running with node.js
scalaJSStage in Global := FastOptStage