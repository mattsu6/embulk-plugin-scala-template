//todo: implement tasks (migrate build.gradle to build.sbt)
//lazy val gemPush = taskKey[Unit]("")
//gemPush := {
//  gem.value
//
//}
//
//lazy val package_embulk = taskKey[Unit]("")
//package_embulk := {
//  gemspec.value
//  classpath.value
//  println "> Build succeeded."
//  println "> You can run embulk with '-L ${file(\".\").absolutePath}' argument."
//}
//
//lazy val gemspec = taskKey[Unit]("")
//gemspec := { }
//
//lazy val gem = taskKey[Unit]("")
//gem := {
//  gemspec.value
//  classpath.value
//}

lazy val classpath = taskKey[Unit]("")

lazy val commonSettings = Seq(
  version := "0.0.1",
  organization := "jp.microad",
  scalaVersion := "2.12.1",
  resolvers += JCenterRepository,
  scalacOptions in Test ++= Seq("-Yrangepos")
)

lazy val root = (project in file(".")).
  settings(commonSettings: _*).
  settings(
    name := "embulk-input-template",
    libraryDependencies ++= Seq(
      "org.embulk" % "embulk-core" % "0.8.16" % "provided",
      "org.specs2" %% "specs2-core" % "3.8.9" % "test",
      "org.specs2" %% "specs2-mock" % "3.8.9" % "test"
    ),
    classpath := {
      (Keys.`package` in Compile).value
      val src = new File(s"${(packageBin in Compile).value}")
      val dst = new File(s"${baseDirectory.value}/classpath/${artifact.value.name}.${artifact.value.`type`}")
      IO.delete(dst)
      IO.copyFile(src, dst)
    }
  )
