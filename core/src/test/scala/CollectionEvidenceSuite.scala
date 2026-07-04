package com.alecdorrington.scalgebra

import com.alecdorrington.scalgebra.normed.NormedAdditiveMonoid

/**
  * Tests for the built-in [[NormedAdditiveMonoid]] evidence for standard
  * library collections.
  */
class CollectionEvidenceSuite extends munit.FunSuite:

  test("lists concatenate, with length as norm"):
    val L = summon[NormedAdditiveMonoid[List[Int], Int]]
    assertEquals(L.zero, Nil)
    assertEquals(L.add(List(1))(List(2, 3)), List(1, 2, 3))
    assertEquals(L.length(List(1, 2, 3)), 3)
    assertEquals(
      L.sumOrZero(Seq(List(1), List(2), List(3))),
      List(1, 2, 3),
    )

  test("strings concatenate, with length as norm"):
    val S = summon[NormedAdditiveMonoid[String, Int]]
    assertEquals(S.zero, "")
    assertEquals(S.add("foo")("bar"), "foobar")
    assertEquals(S.length("foo"), 3)
    assertEquals(S.scale("ab")(3), "ababab")
    assertEquals(S.scale("ab")(0), "")

  test("sets unite, with size as norm"):
    val S = summon[NormedAdditiveMonoid[Set[Int], Int]]
    assertEquals(S.zero, Set.empty[Int])
    assertEquals(S.add(Set(1, 2))(Set(2, 3)), Set(1, 2, 3))
    assertEquals(S.length(Set(1, 2, 3)), 3)

  test("options lift their element semigroup"):
    val O = summon[NormedAdditiveMonoid[Option[Int], Int]]
    assertEquals(O.zero, None)
    assertEquals(O.add(Some(2))(Some(3)), Some(5))
    assertEquals(O.add(None)(Some(3)), Some(3))
    assertEquals(O.add(Some(2))(None), Some(2))
    assertEquals(O.length(Some(2)), 1)
    assertEquals(O.length(None), 0)

  test("maps add pointwise, with key count as norm"):
    val M = summon[NormedAdditiveMonoid[Map[String, Int], Int]]
    assertEquals(M.zero, Map.empty[String, Int])
    assertEquals(
      M.add(Map("a" -> 1, "b" -> 2))(Map("b" -> 3, "c" -> 4)),
      Map("a" -> 1, "b" -> 5, "c" -> 4),
    )
    assertEquals(M.length(Map("a" -> 1, "b" -> 2)), 2)
