package com.alecdorrington.scalgebra.connector.spire

import com.alecdorrington.scalgebra as scalgebra
import spire.algebra

/**
  * Implicit conversions between [[scalgebra.arithmetic.MultiplicativeGroup]]
  * and [[spire.algebra.MultiplicativeGroup]].
  */
trait MultiplicativeGroupSpireConversions:

  /**
    * Derives a [[spire.algebra.MultiplicativeGroup]] from a
    * [[scalgebra.arithmetic.MultiplicativeGroup]].
    */
  given multiplicativeGroupToSpire
    : [X : scalgebra.arithmetic.MultiplicativeGroup as S]
      => algebra.MultiplicativeGroup[X]:

    def times(x: X, y: X): X = x * y
    def one: X               = S.one
    def div(x: X, y: X): X   = x / y

  /**
    * Derives a [[scalgebra.arithmetic.MultiplicativeGroup]] from a
    * [[spire.algebra.MultiplicativeGroup]].
    */
  given multiplicativeGroupFromSpire
    : [X : algebra.MultiplicativeGroup as S]
      => scalgebra.arithmetic.MultiplicativeGroup[X]:

    override def one: X = S.one

    extension (x: X)

      override def mul(y: X): X  = S.times(x, y)
      override def reciprocal: X = S.reciprocal(x)
