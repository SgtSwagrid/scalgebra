package com.alecdorrington.scalgebra

import com.alecdorrington.scalgebra.ordered.OrderedQuotientRing

/**
  * Tests for the built-in [[OrderedQuotientRing]] evidence for [[Int]],
  * covering ring, quotient, and ordering operations.
  */
class IntEvidenceSuite extends munit.FunSuite:

  private val R = summon[OrderedQuotientRing[Int]]

  test("identities"):
    assertEquals(R.zero, 0)
    assertEquals(R.one, 1)
    assertEquals(R.fromInt(0), 0)
    assertEquals(R.fromInt(2), 2)
    assertEquals(R.fromInt(-3), -3)

  test("ring operations"):
    assertEquals(R.add(3)(4), 7)
    assertEquals(R.subtract(3)(4), -1)
    assertEquals(R.negate(5), -5)
    assertEquals(R.mul(6)(7), 42)

  test("division rounds towards zero"):
    assertEquals(R.div(7)(2), 3)
    assertEquals(R.div(-7)(2), -3)
    assertEquals(R.div(7)(-2), -3)

  test("signed remainder"):
    assertEquals(R.mod(7)(2), 1)
    assertEquals(R.mod(-7)(2), -1)
    assertEquals(R.mod(7)(-2), 1)

  test("floored division and remainder"):
    assertEquals(R.floorMod(-7)(2), 1)
    assertEquals(R.floorMod(7)(-2), -1)
    assertEquals(R.floorDiv(-7)(2), -4)

  test("euclidean division and remainder"):
    assertEquals(R.euclideanMod(-7)(2), 1)
    assertEquals(R.euclideanMod(-7)(-2), 1)
    assertEquals(R.euclideanDiv(-7)(2), -4)

  test("gcd and lcm"):
    assertEquals(R.gcd(12)(18), 6)
    assertEquals(R.gcd(0)(5), 5)
    assertEquals(R.lcm(4)(6), 12)

  test("scale by any integer"):
    assertEquals(R.scale(3)(5), 15)
    assertEquals(R.scale(3)(-5), -15)
    assertEquals(R.scale(3)(0), 0)
    for n <- -20 to 20 do assertEquals(R.scale(7)(n), 7 * n)

  test("pow by positive exponent"):
    assertEquals(R.pow(2)(10), 1024)
    for n <- 1 to 15 do assertEquals(R.pow(3)(n), Seq.fill(n)(3).product)

  test("ordering"):
    assert(R.compare(1, 2) < 0)
    assert(R.compare(2, 1) > 0)
    assertEquals(R.compare(2, 2), 0)
    assertEquals(R.min(3)(5), 3)
    assertEquals(R.max(3)(5), 5)
    assertEquals(R.clamp(7)(0, 5), 5)
    assertEquals(R.clamp(-1)(0, 5), 0)
    assertEquals(R.clamp(3)(0, 5), 3)

  test("sign-based operations"):
    assertEquals(R.abs(-3), 3)
    assertEquals(R.abs(3), 3)
    assertEquals(R.sign(-4), -1)
    assertEquals(R.sign(4), 1)
    assertEquals(R.sign(0), 0)
    assert(R.isPositive(3))
    assert(R.isNegative(-3))
    assert(R.isNonNegative(0))

  test("iterable sums and products"):
    assertEquals(R.sumOrZero(Seq(1, 2, 3)), 6)
    assertEquals(R.sumOrZero(Seq.empty[Int]), 0)
    assertEquals(R.sumOption(Seq.empty[Int]), None)
    assertEquals(R.sumFrom(Seq(2, 3))(10), 15)
    assertEquals(R.productOption(Seq(2, 3, 4)), Some(24))
