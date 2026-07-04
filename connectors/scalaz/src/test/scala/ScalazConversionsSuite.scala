package com.alecdorrington.scalgebra.connector.scalaz

/**
  * Tests for the conversions between Scalgebra and Scalaz type classes.
  *
  * The `to` direction is exercised by deriving Scalaz instances from the
  * built-in Scalgebra evidence for [[Int]]. The `from` direction is exercised
  * by feeding those derived instances back through the reverse conversion.
  */
class ScalazConversionsSuite extends munit.FunSuite:

  test("semigroup to and from scalaz"):
    val sg = ScalazConversions.additiveSemigroupToScalaz[Int]
    assertEquals(sg.append(2, 3), 5)
    val S = ScalazConversions.additiveSemigroupFromScalaz[Int](using sg)
    assertEquals(S.add(2)(3), 5)

  test("monoid to and from scalaz"):
    val mon = ScalazConversions.additiveMonoidToScalaz[Int]
    assertEquals(mon.append(2, 3), 5)
    assertEquals(mon.zero, 0)
    val M = ScalazConversions.additiveMonoidFromScalaz[Int](using mon)
    assertEquals(M.zero, 0)
    assertEquals(M.sumOrZero(Seq(1, 2, 3)), 6)

  test("string monoid round-trips through scalaz"):
    val M = ScalazConversions.additiveMonoidFromScalaz[String](
      using ScalazConversions.additiveMonoidToScalaz,
    )
    assertEquals(M.add("foo")("bar"), "foobar")
    assertEquals(M.zero, "")
