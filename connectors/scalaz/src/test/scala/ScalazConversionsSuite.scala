package com.alecdorrington.scalgebra.connector.scalaz

/**
  * Tests for the conversions between Scalgebra and Scalaz type classes.
  *
  * The `to` direction is exercised by deriving Scalaz instances from the
  * built-in Scalgebra evidence for [[Int]]. The `from` direction is exercised
  * by feeding those derived instances back through the reverse conversion.
  */
class ScalazConversionsSuite extends munit.FunSuite:

  test("semigroup and monoid to and from scalaz"):
    val sg = ScalazConversions.additiveSemigroupToScalaz[Int]
    assertEquals(sg.append(2, 3), 5)
    val S = ScalazConversions.additiveSemigroupFromScalaz[Int](using sg)
    assertEquals(S.add(2)(3), 5)
    val mon = ScalazConversions.additiveMonoidToScalaz[Int]
    assertEquals(mon.append(2, 3), 5)
    assertEquals(mon.zero, 0)
    val M = ScalazConversions.additiveMonoidFromScalaz[Int](using mon)
    assertEquals(M.zero, 0)
    assertEquals(M.sumOrZero(Seq(1, 2, 3)), 6)
    // A non-commutative monoid, so that swapped operands would be caught.
    val str = ScalazConversions.additiveMonoidFromScalaz[String](
      using ScalazConversions.additiveMonoidToScalaz,
    )
    assertEquals(str.add("foo")("bar"), "foobar")
    assertEquals(str.zero, "")
