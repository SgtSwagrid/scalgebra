package com.alecdorrington.scalgebra

import com.alecdorrington.scalgebra.arithmetic.{
  AdditiveMonoid, Field, MultiplicativeSemigroup, Semiring,
}

/**
  * Tests that the type classes compose in generic code the way a downstream
  * user would write it, with operators resolved from context bounds.
  */
class GenericUsageSuite extends munit.FunSuite:

  private def sumAll[X : AdditiveMonoid](xs: X*): X = xs.sumOrZero

  private def square[X : MultiplicativeSemigroup](x: X): X = x * x

  private def halfway[X : Field](x: X, y: X): X = (x + y) / Semiring.fromInt(2)

  test("generic sums work across algebras"):
    assertEquals(sumAll(1, 2, 3), 6)
    assertEquals(sumAll("a", "b", "c"), "abc")
    assertEquals(sumAll(List(1), List(2)), List(1, 2))
    assertEquals(sumAll[Int](), 0)

  test("generic products work across algebras"):
    assertEquals(square(7), 49)
    assertEquals(square(1.5), 2.25)

  test("generic field operations work"):
    assertEquals(halfway(1.0, 2.0), 1.5)
