package com.alecdorrington.scalgebra.connector.cats

/**
  * Tests for the conversions between Scalgebra and Cats Algebra type classes.
  *
  * The `to` direction is exercised by deriving Cats instances from the built-in
  * Scalgebra evidence for [[Int]] and [[Double]]. The `from` direction is
  * exercised by feeding those derived instances back through the reverse
  * conversion and checking against ordinary arithmetic.
  */
class CatsConversionsSuite extends munit.FunSuite:

  private val intEuclideanRing: algebra.ring.EuclideanRing[Int] =
    new algebra.ring.EuclideanRing[Int]:
      def zero: Int                         = 0
      def one: Int                          = 1
      def plus(x: Int, y: Int): Int         = x + y
      def negate(x: Int): Int               = -x
      def times(x: Int, y: Int): Int        = x * y
      def euclideanFunction(x: Int): BigInt = BigInt(x).abs
      def equot(x: Int, y: Int): Int        = x / y
      def emod(x: Int, y: Int): Int         = x % y

  test("ring to cats"):
    val ring = CatsConversions.ringToCats[Int]
    assertEquals(ring.plus(2, 3), 5)
    assertEquals(ring.zero, 0)
    assertEquals(ring.negate(4), -4)
    assertEquals(ring.times(3, 4), 12)
    assertEquals(ring.one, 1)

  test("ring from cats"):
    val R = CatsConversions.ringFromCats[Int](using CatsConversions.ringToCats)
    assertEquals(R.add(2)(3), 5)
    assertEquals(R.zero, 0)
    assertEquals(R.negate(4), -4)
    assertEquals(R.mul(3)(4), 12)
    assertEquals(R.one, 1)
    assertEquals(R.subtract(2)(5), -3)

  test("semiring to and from cats (rig)"):
    val rig = CatsConversions.semiringToCats[Int]
    assertEquals(rig.plus(2, 3), 5)
    assertEquals(rig.times(2, 3), 6)
    assertEquals(rig.one, 1)
    val S = CatsConversions.semiringFromCats[Int](using rig)
    assertEquals(S.add(2)(3), 5)
    assertEquals(S.fromInt(2), 2)

  test("pseudoring to and from cats (rng)"):
    val rng = CatsConversions.pseudoringToCats[Int]
    assertEquals(rng.negate(3), -3)
    val P = CatsConversions.pseudoringFromCats[Int](using rng)
    assertEquals(P.mul(3)(4), 12)
    assertEquals(P.negate(3), -3)

  test("additive classes to and from cats"):
    val grp = CatsConversions.additiveGroupToCats[Int]
    assertEquals(grp.plus(2, 3), 5)
    assertEquals(grp.negate(2), -2)
    val G = CatsConversions.additiveGroupFromCats[Int](using grp)
    assertEquals(G.subtract(2)(5), -3)
    val mon = CatsConversions.additiveMonoidToCats[Int]
    assertEquals(mon.zero, 0)
    val M = CatsConversions.additiveMonoidFromCats[Int](using mon)
    assertEquals(M.sumOrZero(Seq(1, 2, 3)), 6)

  test("multiplicative classes to and from cats"):
    val mon = CatsConversions.multiplicativeMonoidToCats[Int]
    assertEquals(mon.times(3, 4), 12)
    assertEquals(mon.one, 1)
    val grp = CatsConversions.multiplicativeGroupToCats[Double]
    assertEquals(grp.div(1.0, 4.0), 0.25)
    assertEquals(grp.reciprocal(4.0), 0.25)
    val G = CatsConversions.multiplicativeGroupFromCats[Double](using grp)
    assertEquals(G.reciprocal(4.0), 0.25)
    assertEquals(G.div(1.0)(4.0), 0.25)

  test("field and semifield to and from cats"):
    val fld = CatsConversions.fieldToCats[Double]
    assertEquals(fld.div(1.0, 4.0), 0.25)
    val F = CatsConversions.fieldFromCats[Double](using fld)
    assertEquals(F.reciprocal(4.0), 0.25)
    assertEquals(F.negate(1.5), -1.5)
    val sf = CatsConversions.semifieldToCats[Double]
    assertEquals(sf.div(1.0, 4.0), 0.25)
    val SF = CatsConversions.semifieldFromCats[Double](using sf)
    assertEquals(SF.reciprocal(4.0), 0.25)

  test("order to and from cats"):
    val ord = CatsConversions.orderedToCats[Int]
    assert(ord.compare(1, 2) < 0)
    assert(ord.compare(2, 1) > 0)
    assertEquals(ord.compare(2, 2), 0)
    val O = CatsConversions.orderedFromCats[Int](using ord)
    assertEquals(O.min(3)(5), 3)
    assertEquals(O.max(3)(5), 5)

  test("quotient ring from cats euclidean ring"):
    val Q = CatsConversions.quotientRingFromCats[Int](using intEuclideanRing)
    assertEquals(Q.div(7)(2), 3)
    assertEquals(Q.mod(7)(2), 1)
    assertEquals(Q.gcd(12)(18), 6)
