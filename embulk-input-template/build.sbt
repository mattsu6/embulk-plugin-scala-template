//todo: implement tasks
//lazy val gemPush = taskKey[Unit]("")
//gemPush := {
//  gem.value
//
//}
//
//lazy val `package` = taskKey[Unit]("")
//`package` := {
//  gemspec.value
//  classpath.value
//}
//
//lazy val gemspec = taskKey[Unit]("")
//gemspec := { println("aaa") }
//
//lazy val gem = taskKey[Unit]("")
//gem := {
//  gemspec.value
//  classpath.value
//}
//
//lazy val classpath = taskKey[Unit]("")
//classpath := {
//  jar.value
//}

lazy val root = (project in file("."))
  .settings(
    name := "embulk-input-template",
    version := "1.0",
    scalaVersion := "2.12.1",
    resolvers += JCenterRepository,
    libraryDependencies ++= Seq(
      "org.embulk" % "embulk-core" % "0.8.16" % "compile",
      "org.embulk" % "embulk-core" % "0.8.16" % "provided",
      "org.specs2" %% "specs2-core" % "3.8.9" % "test",
      "org.specs2" %% "specs2-mock" % "3.8.9" % "test"
    )
  )
