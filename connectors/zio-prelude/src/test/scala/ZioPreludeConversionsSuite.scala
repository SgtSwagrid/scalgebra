package com.alecdorrington.scalgebra.connector.zioprelude

/**
  * Tests for the conversions between Scalgebra and ZIO Prelude type classes.
  *
  * The `to` direction is exercised by deriving ZIO Prelude instances from the
  * built-in Scalgebra evidence for [[Int]]. The `from` direction is exercised
  * by feeding those derived instances back through the reverse conversion.
  */
class ZioPreludeConversionsSuite extends munit.FunSuite:

  test("associative to and from zio prelude"):
    val assoc = ZioPreludeConversions.additiveSemigroupToZioPrelude[Int]
    assertEquals(assoc.combine(2, 3), 5)
    val S =
      ZioPreludeConversions.additiveSemigroupFromZioPrelude[Int](using assoc)
    assertEquals(S.add(2)(3), 5)

  test("identity to and from zio prelude"):
    val id = ZioPreludeConversions.additiveMonoidToZioPrelude[Int]
    assertEquals(id.combine(2, 3), 5)
    assertEquals(id.identity, 0)
    val M = ZioPreludeConversions.additiveMonoidFromZioPrelude[Int](using id)
    assertEquals(M.zero, 0)
    assertEquals(M.sumOrZero(Seq(1, 2, 3)), 6)

  test("inverse to and from zio prelude"):
    val inv = ZioPreludeConversions.differenceMonoidToZioPrelude[Int]
    assertEquals(inv.inverse(5, 3), 2)
    assertEquals(inv.identity, 0)
    val D = ZioPreludeConversions.differenceMonoidFromZioPrelude[Int](using inv)
    assertEquals(D.subtract(5)(3), 2)
    assertEquals(D.add(2)(3), 5)
    assertEquals(D.zero, 0)
