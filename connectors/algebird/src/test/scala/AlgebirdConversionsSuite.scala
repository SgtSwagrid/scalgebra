package com.alecdorrington.scalgebra.connector.algebird

/**
  * Tests for the conversions between Scalgebra and Algebird type classes.
  *
  * The `to` direction is exercised by deriving Algebird instances from the
  * built-in Scalgebra evidence for [[Int]] and [[Double]]. The `from` direction
  * is exercised by feeding those derived instances back through the reverse
  * conversion.
  */
class AlgebirdConversionsSuite extends munit.FunSuite:

  test("semigroup to and from algebird"):
    val sg = AlgebirdConversions.additiveSemigroupToAlgebird[Int]
    assertEquals(sg.plus(2, 3), 5)
    val S = AlgebirdConversions.additiveSemigroupFromAlgebird[Int](using sg)
    assertEquals(S.add(2)(3), 5)

  test("monoid to and from algebird"):
    val mon = AlgebirdConversions.additiveMonoidToAlgebird[Int]
    assertEquals(mon.plus(2, 3), 5)
    assertEquals(mon.zero, 0)
    val M = AlgebirdConversions.additiveMonoidFromAlgebird[Int](using mon)
    assertEquals(M.zero, 0)
    assertEquals(M.sumOrZero(Seq(1, 2, 3)), 6)

  test("group to and from algebird"):
    val grp = AlgebirdConversions.additiveGroupToAlgebird[Int]
    assertEquals(grp.negate(4), -4)
    val G = AlgebirdConversions.additiveGroupFromAlgebird[Int](using grp)
    assertEquals(G.negate(4), -4)
    assertEquals(G.subtract(2)(5), -3)

  test("ring to and from algebird"):
    val ring = AlgebirdConversions.ringToAlgebird[Int]
    assertEquals(ring.times(3, 4), 12)
    assertEquals(ring.one, 1)
    val R = AlgebirdConversions.ringFromAlgebird[Int](using ring)
    assertEquals(R.mul(3)(4), 12)
    assertEquals(R.one, 1)

  test("field to and from algebird"):
    val fld = AlgebirdConversions.fieldToAlgebird[Double]
    assertEquals(fld.div(1.0, 4.0), 0.25)
    assertEquals(fld.one, 1.0)
    val F = AlgebirdConversions.fieldFromAlgebird[Double](using fld)
    assertEquals(F.reciprocal(4.0), 0.25)
    assertEquals(F.div(1.0)(4.0), 0.25)
