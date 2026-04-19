package com.alecdorrington.scalgebra.connector.cats

import com.alecdorrington.{scalgebra as structures}

/**
  * Implicit conversions between [[structures.MultiplicativeGroup]] and
  * [[algebra.ring.MultiplicativeGroup]].
  */
trait MultiplicativeGroupCatsConversions:

  /**
    * Derives an [[algebra.ring.MultiplicativeGroup]] from a
    * [[structures.MultiplicativeGroup]].
    */
  given multiplicativeGroupToCats[X : structures.MultiplicativeGroup as S]
    : algebra.ring.MultiplicativeGroup[X] with

    def times(x: X, y: X): X = S.multiply(x, y)
    def one: X               = S.one
    def div(x: X, y: X): X   = S.divide(x, y)

  /**
    * Derives a [[structures.MultiplicativeGroup]] from an
    * [[algebra.ring.MultiplicativeGroup]].
    */
  given multiplicativeGroupFromCats[X : algebra.ring.MultiplicativeGroup as S]
    : structures.MultiplicativeGroup[X] with

    def multiply(x: X, y: X): X = S.times(x, y)
    def one: X                  = S.one
    def reciprocate(x: X): X    = S.reciprocal(x)
