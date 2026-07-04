package com.alecdorrington.scalgebra.connector.spire

/**
  * Tests for the conversions between Scalgebra and Spire type classes.
  *
  * The `to` direction is exercised by deriving Spire instances from the
  * built-in Scalgebra evidence for [[Int]] and [[Double]]. The `from` direction
  * is exercised by feeding those derived instances (or Spire's own standard
  * instances) back through the reverse conversion.
  */
class SpireConversionsSuite extends munit.FunSuite:

  test("ring to spire"):
    val ring = SpireConversions.ringToSpire[Int]
    assertEquals(ring.plus(2, 3), 5)
    assertEquals(ring.zero, 0)
    assertEquals(ring.negate(4), -4)
    assertEquals(ring.times(3, 4), 12)
    assertEquals(ring.one, 1)

  test("ring from spire"):
    val R =
      SpireConversions.ringFromSpire[Int](using SpireConversions.ringToSpire)
    assertEquals(R.add(2)(3), 5)
    assertEquals(R.mul(3)(4), 12)
    assertEquals(R.negate(4), -4)
    assertEquals(R.subtract(2)(5), -3)

  test("semiring to and from spire"):
    val rig = SpireConversions.semiringToSpire[Int]
    assertEquals(rig.plus(2, 3), 5)
    assertEquals(rig.times(2, 3), 6)
    val S = SpireConversions.semiringFromSpire[Int](using rig)
    assertEquals(S.add(2)(3), 5)
    assertEquals(S.fromInt(2), 2)

  test("pseudoring to and from spire"):
    val rng = SpireConversions.pseudoringToSpire[Int]
    assertEquals(rng.negate(3), -3)
    val P = SpireConversions.pseudoringFromSpire[Int](using rng)
    assertEquals(P.mul(3)(4), 12)

  test("additive classes to and from spire"):
    val grp = SpireConversions.additiveGroupToSpire[Int]
    assertEquals(grp.plus(2, 3), 5)
    assertEquals(grp.negate(2), -2)
    val G = SpireConversions.additiveGroupFromSpire[Int](using grp)
    assertEquals(G.subtract(2)(5), -3)
    val M = SpireConversions.additiveMonoidFromSpire[Int](
      using SpireConversions.additiveMonoidToSpire,
    )
    assertEquals(M.sumOrZero(Seq(1, 2, 3)), 6)

  test("multiplicative classes to and from spire"):
    val mon = SpireConversions.multiplicativeMonoidToSpire[Int]
    assertEquals(mon.times(3, 4), 12)
    val grp = SpireConversions.multiplicativeGroupToSpire[Double]
    assertEquals(grp.div(1.0, 4.0), 0.25)
    val G = SpireConversions.multiplicativeGroupFromSpire[Double](using grp)
    assertEquals(G.reciprocal(4.0), 0.25)

  test("field to and from spire"):
    val fld = SpireConversions.fieldToSpire[Double]
    assertEquals(fld.div(1.0, 4.0), 0.25)
    val F = SpireConversions.fieldFromSpire[Double](using fld)
    assertEquals(F.reciprocal(4.0), 0.25)
    assertEquals(F.negate(1.5), -1.5)

  test("quotient ring from spire euclidean ring"):
    val Q = SpireConversions.quotientRingFromSpire[Int](
      using spire.std.int.IntAlgebra,
    )
    assertEquals(Q.add(2)(3), 5)
    assertEquals(Q.div(7)(2), 3)
    assertEquals(Q.mod(7)(2), 1)
    assertEquals(Q.gcd(12)(18), 6)

  test("archimedean from spire is-real"):
    val A = SpireConversions.archimedeanFromSpire[Double](
      using spire.std.double.DoubleAlgebra,
    )
    assert(A.compare(1.0, 2.0) < 0)
    assertEquals(A.floor(1.75), 1.0)
    assertEquals(A.floor(-1.25), -2.0)
    assertEquals(A.ceil(1.25), 2.0)
    assert(A.isIntegral(2.0))
    assert(A.isFractional(2.5))
