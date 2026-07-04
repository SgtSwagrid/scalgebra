package com.alecdorrington.scalgebra

import com.alecdorrington.scalgebra.arithmetic.{
  AdditiveMonoid, AdditiveSemigroup, MultiplicativeSemigroup, Ring,
}

/**
  * Tests for the repeated-addition ([[AdditiveSemigroup.scale]]) and
  * repeated-multiplication ([[MultiplicativeSemigroup.pow]]) algorithms,
  * including on structures without identities.
  */
class ScaleAndPowSuite extends munit.FunSuite:

  /** A semigroup with no identity, where addition is `max`. */
  private case class Max(v: Int)

  private object Max:

    given AdditiveSemigroup[Max]:
      extension (a: Max) override def add(b: Max): Max = Max(a.v max b.v)

  test("scale on a bare semigroup works for any positive multiplier"):
    val S = summon[AdditiveSemigroup[Max]]
    for n <- 1 to 20 do assertEquals(S.scale(Max(3))(n), Max(3))

  test("scale on a bare semigroup rejects non-positive multipliers"):
    val S = summon[AdditiveSemigroup[Max]]
    intercept[IllegalArgumentException](S.scale(Max(3))(0))
    intercept[IllegalArgumentException](S.scale(Max(3))(-1))

  test("scale on a monoid accepts zero but rejects negative multipliers"):
    val S = summon[AdditiveMonoid[String]]
    assertEquals(S.scale("x")(0), "")
    intercept[IllegalArgumentException](S.scale("x")(-1))

  test("scale agrees with naive repeated addition"):
    val S = summon[AdditiveMonoid[String]]
    for n <- 0 to 20 do assertEquals(S.scale("ab")(n), "ab" * n)

  test("pow agrees with naive repeated multiplication"):
    val R = summon[Ring[Int]]
    for
      x <- -3 to 3
      n <- 1 to 15
    do assertEquals(R.pow(x)(n), Seq.fill(n)(x).product)

  test("scale does not overflow the stack for large multipliers"):
    val R = summon[Ring[Int]]
    assertEquals(R.scale(1)(Int.MaxValue), Int.MaxValue)
    assertEquals(R.scale(0)(Int.MaxValue), 0)
