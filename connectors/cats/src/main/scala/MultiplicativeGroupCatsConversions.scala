package com.alecdorrington.scalgebra.connector.cats

import com.alecdorrington.scalgebra as scalgebra

/**
  * Implicit conversions between [[scalgebra.arithmetic.MultiplicativeGroup]]
  * and [[algebra.ring.MultiplicativeGroup]].
  */
trait MultiplicativeGroupCatsConversions:

  /**
    * Derives an [[algebra.ring.MultiplicativeGroup]] from a
    * [[scalgebra.arithmetic.MultiplicativeGroup]].
    */
  given multiplicativeGroupToCats
    : [X : scalgebra.arithmetic.MultiplicativeGroup as S]
      => algebra.ring.MultiplicativeGroup[X]:

    def times(x: X, y: X): X = x * y
    def one: X               = S.one
    def div(x: X, y: X): X   = x / y

  /**
    * Derives a [[scalgebra.arithmetic.MultiplicativeGroup]] from an
    * [[algebra.ring.MultiplicativeGroup]].
    */
  given multiplicativeGroupFromCats
    : [X : algebra.ring.MultiplicativeGroup as S]
      => scalgebra.arithmetic.MultiplicativeGroup[X]:

    override def one: X = S.one

    extension (x: X)

      override def mul(y: X): X  = S.times(x, y)
      override def reciprocal: X = S.reciprocal(x)
