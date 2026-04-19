import IdeSettings.packagePrefix
import sbt._
import sbt.Keys._
import sbtunidoc.BaseUnidocPlugin.autoImport.*
import sbtunidoc.ScalaUnidocPlugin

ThisBuild / scalaVersion := "3.8.3"

ThisBuild / scalacOptions ++= Seq(
  "-explain",
  "-explain-types",
  "-explain-cyclic",
  "-language:experimental.subCases",
  "-language:experimental.relaxedLambdaSyntax",
  "-language:experimental.multiSpreads",
  "-language:experimental.strictEqualityPatternMatching",
  "-language:experimental.erasedDefinitions",
)

lazy val `scalgebra-root` = project
  .in(file("."))
  .enablePlugins(ScalaUnidocPlugin)
  .aggregate(
    `scalgebra`,
    `scalgebra-connector-algebird`,
    `scalgebra-connector-breeze`,
    `scalgebra-connector-cats`,
    `scalgebra-connector-scalaz`,
    `scalgebra-connector-spire`,
    `scalgebra-connector-zio-prelude`,
  )

lazy val `scalgebra` = project
  .in(file("."))
  .settings(packagePrefix := "com.alecdorrington.scalgebra")

lazy val `scalgebra-connector-algebird` = project
  .in(file("connectors/algebird"))
  .dependsOn(`scalgebra`)
  .settings(
    packagePrefix := "com.alecdorrington.scalgebra.connector.algebird",
    libraryDependencies += ("com.twitter" %% "algebird-core" % "0.13.10").cross(
      CrossVersion.for3Use2_13,
    ),
  )

lazy val `scalgebra-connector-breeze` = project
  .in(file("connectors/breeze"))
  .dependsOn(`scalgebra`)
  .settings(
    packagePrefix := "com.alecdorrington.scalgebra.connector.breeze",
    libraryDependencies += "org.scalanlp" %% "breeze" % "2.1.0",
  )

lazy val `scalgebra-connector-cats` = project
  .in(file("connectors/cats"))
  .dependsOn(`scalgebra`)
  .settings(
    packagePrefix := "com.alecdorrington.scalgebra.connector.cats",
    libraryDependencies += "org.typelevel" %% "algebra" % "2.13.0",
  )

lazy val `scalgebra-connector-scalaz` = project
  .in(file("connectors/scalaz"))
  .dependsOn(`scalgebra`)
  .settings(
    packagePrefix := "com.alecdorrington.scalgebra.connector.scalaz",
    libraryDependencies += "org.scalaz" %% "scalaz-core" % "7.3.8",
  )

lazy val `scalgebra-connector-spire` = project
  .in(file("connectors/spire"))
  .dependsOn(`scalgebra`)
  .settings(
    packagePrefix := "com.alecdorrington.scalgebra.connector.spire",
    libraryDependencies += "org.typelevel" %% "spire" % "0.18.0",
  )

lazy val `scalgebra-connector-zio-prelude` = project
  .in(file("connectors/zio-prelude"))
  .dependsOn(`scalgebra`)
  .settings(
    packagePrefix := "com.alecdorrington.scalgebra.connector.zioprelude",
    libraryDependencies += "dev.zio" %% "zio-prelude" % "1.0.0-RC39",
  )
