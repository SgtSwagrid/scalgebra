package com.alecdorrington.scalgebra.connector.zioprelude

import com.alecdorrington.scalgebra as scalgebra

/**
  * Implicit conversions between [[scalgebra.arithmetic.AdditiveSemigroup]] and
  * [[zio.prelude.Associative]].
  *
  * @note
  *   [[zio.prelude.Associative.combine]] takes both arguments by-name, whereas
  *   [[scalgebra.arithmetic.AdditiveSemigroup.add]] is strict. Both directions
  *   evaluate arguments strictly.
  */
trait AdditiveSemigroupZioPreludeConversions:

  /**
    * Derives a [[zio.prelude.Associative]] from an
    * [[scalgebra.arithmetic.AdditiveSemigroup]].
    */
  given additiveSemigroupToZioPrelude
    : [X : scalgebra.arithmetic.AdditiveSemigroup as S]
      => zio.prelude.Associative[X]:
    def combine(x: => X, y: => X): X = x + y

  /**
    * Derives an [[scalgebra.arithmetic.AdditiveSemigroup]] from a
    * [[zio.prelude.Associative]].
    */
  given additiveSemigroupFromZioPrelude
    : [X : zio.prelude.Associative as S]
      => scalgebra.arithmetic.AdditiveSemigroup[X]:
    extension (x: X) override def add(y: X): X = S.combine(x, y)
