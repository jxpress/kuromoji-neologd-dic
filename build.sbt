name := "kuromoji-neologd-dic"

organization := "net.jxpress"

version := "0.0.9"

scalaVersion := "2.11.7"

resolvers += "Maven Repository on Github" at "http://jxpress.github.io/mvnrepos/"

libraryDependencies ++= Seq()

mavenRepositoryName := "mvnrepos"
gitHubURI := "git@github.com:jxpress/mvnrepos.git"
MvnReposOnGitHubPlugin.projectSettings

publishMavenStyle := true

publishArtifact in (Compile, packageBin) := true
publishArtifact in (Compile, packageDoc) := false
publishArtifact in (Compile, packageSrc) := false
publishArtifact in Test := false

lazy val  buildDictionary = taskKey[Unit]("")

buildDictionary := {

  val scriptRepo = "kuromoji-with-mecab-neologd-buildscript"
  val scriptURL = s"https://github.com/kazuhira-r/$scriptRepo.git"
  val script    = "build-atilika-kuromoji-with-mecab-ipadic-neologd.sh"
  val workspace = target.value / "neologd"
  val dicDir = file(s"$workspace/$scriptRepo/kuromoji/kuromoji-ipadic/target/classes/com/atilika/kuromoji/ipadic")
  val outDir = file("src/main/resources/ipadic/neologd/")

  IO.createDirectory(workspace)

  IO.createDirectory(outDir)

  scala.sys.process.Process(s"git clone $scriptURL", workspace) !!

  scala.sys.process.Process(s"sh $script", workspace / s"$scriptRepo") !

  IO.delete(outDir.listFiles.filter { _.isFile }.filter {_.getPath.endsWith(".bin")})

  dicDir.listFiles.filter { _.isFile }.filter {_.getPath.endsWith(".bin")}.foreach {
    src =>
      val dist = file(s"$outDir/${src.getName}")
      println(s"copy $src => $dist")
      IO.copyFile(src, dist)
  }
}



