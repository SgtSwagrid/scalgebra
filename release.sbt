ThisBuild / description :=
  "A collection of type classes for algebraic structures in Scala."

ThisBuild / homepage :=
  Some(url("https://github.com/SgtSwagrid/scalgebra"))

ThisBuild / organization         := "com.alecdorrington"
ThisBuild / organizationName     := "Alec Dorrington"
ThisBuild / organizationHomepage := Some(url("https://alecdorrington.com"))

ThisBuild / versionScheme := Some("strict")

ThisBuild / licenses :=
  List("MIT" -> url("https://opensource.org/licenses/MIT"))

ThisBuild / developers := List(Developer(
  id = "SgtSwagrid",
  name = "Alec Dorrington",
  email = "alecdorrington@gmail.com",
  url = url("https://github.com/SgtSwagrid"),
))

// Target the Sonatype Central Portal (https://central.sonatype.com).
// Requires SONATYPE_USERNAME and SONATYPE_PASSWORD as GitHub secrets or environment variables.
ThisBuild / sonatypeCredentialHost := "central.sonatype.com"
