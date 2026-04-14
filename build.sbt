import IdeSettings.packagePrefix
import sbt._
import sbt.Keys._

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

lazy val `not-enough-structures` = project
  .in(file("."))
  .settings(packagePrefix := "io.github.sgtswagrid.structures")

lazy val `not-enough-structures-connector-algebird` = project
  .in(file("connectors/algebird"))
  .dependsOn(`not-enough-structures`)
  .settings(
    packagePrefix := "io.github.sgtswagrid.structures.connector.algebird",
    libraryDependencies += ("com.twitter" %% "algebird-core" % "0.13.10").cross(
      CrossVersion.for3Use2_13,
    ),
  )

lazy val `not-enough-structures-connector-breeze` = project
  .in(file("connectors/breeze"))
  .dependsOn(`not-enough-structures`)
  .settings(
    packagePrefix := "io.github.sgtswagrid.structures.connector.breeze",
    libraryDependencies += "org.scalanlp" %% "breeze" % "2.1.0",
  )

lazy val `not-enough-structures-connector-cats` = project
  .in(file("connectors/cats"))
  .dependsOn(`not-enough-structures`)
  .settings(
    packagePrefix := "io.github.sgtswagrid.structures.connector.cats",
    libraryDependencies += "org.typelevel" %% "algebra" % "2.13.0",
  )

lazy val `not-enough-structures-connector-scalaz` = project
  .in(file("connectors/scalaz"))
  .dependsOn(`not-enough-structures`)
  .settings(
    packagePrefix := "io.github.sgtswagrid.structures.connector.scalaz",
    libraryDependencies += "org.scalaz" %% "scalaz-core" % "7.3.8",
  )

lazy val `not-enough-structures-connector-spire` = project
  .in(file("connectors/spire"))
  .dependsOn(`not-enough-structures`)
  .settings(
    packagePrefix := "io.github.sgtswagrid.structures.connector.spire",
    libraryDependencies += "org.typelevel" %% "spire" % "0.18.0",
  )

lazy val `not-enough-structures-connector-zio-prelude` = project
  .in(file("connectors/zio-prelude"))
  .dependsOn(`not-enough-structures`)
  .settings(
    packagePrefix := "io.github.sgtswagrid.structures.connector.zioprelude",
    libraryDependencies += "dev.zio" %% "zio-prelude" % "1.0.0-RC39",
  )
