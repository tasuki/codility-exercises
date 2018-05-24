scalaVersion := "2.12.5"

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "3.0.5" % Test
)

run / connectInput := true
Test / scalacOptions ++= Seq("-Yrangepos")
