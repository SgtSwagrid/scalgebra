package com.alecdorrington.scalgebra.connector.zioprelude

import com.alecdorrington.scalgebra as scalgebra

/**
  * Implicit conversions between [[scalgebra.arithmetic.AdditiveMonoid]] and
  * [[zio.prelude.Identity]].
  */
trait AdditiveMonoidZioPreludeConversions:

  /**
    * Derives a [[zio.prelude.Identity]] from an
    * [[scalgebra.arithmetic.AdditiveMonoid]].
    */
  given additiveMonoidToZioPrelude
    : [X : scalgebra.arithmetic.AdditiveMonoid as S] => zio.prelude.Identity[X]:

    def combine(x: => X, y: => X): X = x + y
    def identity: X                  = S.zero

  /**
    * Derives an [[scalgebra.arithmetic.AdditiveMonoid]] from a
    * [[zio.prelude.Identity]].
    */
  given additiveMonoidFromZioPrelude
    : [X : zio.prelude.Identity as S] => scalgebra.arithmetic.AdditiveMonoid[X]:

    override def zero: X = S.identity

    extension (x: X) override def add(y: X): X = S.combine(x, y)
