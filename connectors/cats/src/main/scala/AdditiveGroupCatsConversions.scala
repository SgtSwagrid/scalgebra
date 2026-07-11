package com.alecdorrington.scalgebra.connector.cats

import com.alecdorrington.scalgebra as scalgebra

/**
  * Implicit conversions between [[scalgebra.arithmetic.AdditiveGroup]] and
  * [[algebra.ring.AdditiveGroup]].
  */
trait AdditiveGroupCatsConversions:

  /**
    * Derives an [[algebra.ring.AdditiveGroup]] from an
    * [[scalgebra.arithmetic.AdditiveGroup]].
    */
  given additiveGroupToCats
    : [X : scalgebra.arithmetic.AdditiveGroup as S]
      => algebra.ring.AdditiveGroup[X]:

    def plus(x: X, y: X): X = x + y
    def zero: X             = S.zero
    def negate(x: X): X     = x.negate

  /**
    * Derives an [[scalgebra.arithmetic.AdditiveGroup]] from an
    * [[algebra.ring.AdditiveGroup]].
    */
  given additiveGroupFromCats
    : [X : algebra.ring.AdditiveGroup as S]
      => scalgebra.arithmetic.AdditiveGroup[X]:

    override def zero: X = S.zero

    extension (x: X)

      override def add(y: X): X = S.plus(x, y)
      override def negate: X    = S.negate(x)
