package com.alecdorrington.scalgebra

import com.alecdorrington.scalgebra.arithmetic.Ring
import com.alecdorrington.scalgebra.ordered.OrderedRing

/**
  * Tests for the built-in evidence for tuples (componentwise operations,
  * lexicographic order) and functions (pointwise operations).
  */
class TupleFunctionEvidenceSuite extends munit.FunSuite:

  test("pairs operate componentwise"):
    val T = summon[OrderedRing[(Int, Int)]]
    assertEquals(T.zero, (0, 0))
    assertEquals(T.one, (1, 1))
    assertEquals(T.add((1, 2))((3, 4)), (4, 6))
    assertEquals(T.mul((2, 3))((4, 5)), (8, 15))
    assertEquals(T.negate((1, -2)), (-1, 2))

  test("pairs order lexicographically"):
    val T = summon[OrderedRing[(Int, Int)]]
    assert(T.compare((1, 5), (2, 0)) < 0)
    assert(T.compare((1, 5), (1, 4)) > 0)
    assertEquals(T.compare((1, 5), (1, 5)), 0)

  test("triples operate componentwise"):
    val T = summon[OrderedRing[(Int, Int, Int)]]
    assertEquals(T.add((1, 2, 3))((4, 5, 6)), (5, 7, 9))
    assert(T.compare((1, 1, 1), (1, 1, 2)) < 0)

  test("functions operate pointwise"):
    val F      = summon[Ring[Int => Int]]
    val double = (x: Int) => x * 2
    val inc    = (x: Int) => x + 1
    assertEquals(F.add(double)(inc)(3), 10)
    assertEquals(F.mul(double)(inc)(3), 24)
    assertEquals(F.negate(double)(3), -6)
    assertEquals(F.zero(3), 0)
    assertEquals(F.one(3), 1)
