package com.alecdorrington.scalgebra.connector.breeze

import breeze.math

/**
  * Tests for the conversions between Scalgebra and Breeze type classes.
  *
  * The `to` direction is exercised by deriving Breeze instances from the
  * built-in Scalgebra evidence. The `from` direction is exercised against
  * Breeze's own standard instances, since it is norm-carrying and one-way.
  */
class BreezeConversionsSuite extends munit.FunSuite:

  test("semiring to breeze"):
    val sr = BreezeConversions.semiringToBreeze[Int]
    assertEquals(sr.+(2, 3), 5)
    assertEquals(sr.*(3, 4), 12)
    assertEquals(sr.zero, 0)
    assertEquals(sr.one, 1)

  test("semiring from breeze"):
    val S = BreezeConversions.semiringFromBreeze[Int](
      using BreezeConversions.semiringToBreeze,
    )
    assertEquals(S.add(2)(3), 5)
    assertEquals(S.mul(3)(4), 12)
    assertEquals(S.fromInt(2), 2)

  test("normed ring from breeze"):
    val R = BreezeConversions.normedRingFromBreeze[Int](using math.Ring.ringInt)
    assertEquals(R.add(2)(3), 5)
    assertEquals(R.negate(4), -4)
    assertEquals(R.mul(3)(4), 12)
    assertEquals(R.length(3), 3.0)

  test("normed field from breeze"):
    val F = BreezeConversions.normedFieldFromBreeze[Double](
      using math.Field.fieldDouble,
    )
    assertEquals(F.add(0.5)(0.25), 0.75)
    assertEquals(F.reciprocal(4.0), 0.25)
    assertEquals(F.div(1.0)(4.0), 0.25)
    assertEquals(F.length(2.5), 2.5)
