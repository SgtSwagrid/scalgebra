package com.alecdorrington.scalgebra

import com.alecdorrington.scalgebra.archimedean.ArchimedeanField

/**
  * Tests for the built-in [[ArchimedeanField]] evidence for [[Double]],
  * covering field operations and rounding.
  *
  * All expected values are exactly representable in binary floating point, so
  * comparisons are exact.
  */
class DoubleEvidenceSuite extends munit.FunSuite:

  private val F = summon[ArchimedeanField[Double]]

  test("field operations, with mod always zero and no reciprocal of zero"):
    assertEquals(F.reciprocal(4.0), 0.25)
    assertEquals(F.div(1.0)(4.0), 0.25)
    assertEquals(F.mul(0.5)(8.0), 4.0)
    assertEquals(F.subtract(1.5)(0.25), 1.25)
    assertEquals(F.mod(7.5)(2.0), 0.0)
    assertEquals(F.reciprocalOption(0.0), None)
    assertEquals(F.reciprocalOption(4.0), Some(0.25))

  test("pow by any integer"):
    assertEquals(F.pow(2.0)(10), 1024.0)
    assertEquals(F.pow(2.0)(-2), 0.25)
    assertEquals(F.pow(2.0)(0), 1.0)

  test("floor, ceil, truncate, round and remainder"):
    assertEquals(F.floor(1.75), 1.0)
    assertEquals(F.floor(-1.25), -2.0)
    assertEquals(F.ceil(1.25), 2.0)
    assertEquals(F.ceil(-1.75), -1.0)
    assertEquals(F.floor(2.0), 2.0)
    assertEquals(F.ceil(2.0), 2.0)
    assertEquals(F.truncate(1.75), 1.0)
    assertEquals(F.truncate(-1.75), -1.0)
    assertEquals(F.round(1.25), 1.0)
    assertEquals(F.round(1.75), 2.0)
    assertEquals(F.round(-1.25), -1.0)
    assertEquals(F.remainder(7.5)(2.0), 1.5)

  test("frac is the distance below to the previous whole value"):
    assertEquals(F.frac(1.75), 0.75)
    assertEquals(F.frac(-0.25), 0.75)
    assertEquals(F.frac(3.0), 0.0)
    assert(F.isIntegral(2.0))
    assert(F.isFractional(2.5))
