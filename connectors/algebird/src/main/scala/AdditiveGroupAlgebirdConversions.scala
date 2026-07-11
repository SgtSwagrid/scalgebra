package com.alecdorrington.scalgebra.connector.algebird

import com.alecdorrington.scalgebra as scalgebra
import com.twitter.algebird

/**
  * Implicit conversions between [[scalgebra.arithmetic.AdditiveGroup]] and
  * [[algebird.Group]].
  */
trait AdditiveGroupAlgebirdConversions:

  /**
    * Derives an [[algebird.Group]] from an
    * [[scalgebra.arithmetic.AdditiveGroup]].
    */
  given additiveGroupToAlgebird
    : [X : scalgebra.arithmetic.AdditiveGroup as S] => algebird.Group[X]:

    def plus(x: X, y: X): X = x + y
    def zero: X             = S.zero
    def negate(x: X): X     = x.negate

  /**
    * Derives an [[scalgebra.arithmetic.AdditiveGroup]] from an
    * [[algebird.Group]].
    */
  given additiveGroupFromAlgebird
    : [X : algebird.Group as S] => scalgebra.arithmetic.AdditiveGroup[X]:

    override def zero: X = S.zero

    extension (x: X)

      override def add(y: X): X = S.plus(x, y)
      override def negate: X    = S.negate(x)
