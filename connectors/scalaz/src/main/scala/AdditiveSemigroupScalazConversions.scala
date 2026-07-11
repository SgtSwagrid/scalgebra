package com.alecdorrington.scalgebra.connector.scalaz

import com.alecdorrington.scalgebra as scalgebra

/**
  * Implicit conversions between [[scalgebra.arithmetic.AdditiveSemigroup]] and
  * [[scalaz.Semigroup]].
  *
  * @note
  *   [[scalaz.Semigroup.append]] takes its second argument by-name, whereas
  *   [[scalgebra.arithmetic.AdditiveSemigroup.add]] is strict. Both directions
  *   evaluate arguments strictly.
  */
trait AdditiveSemigroupScalazConversions:

  /**
    * Derives a [[scalaz.Semigroup]] from an
    * [[scalgebra.arithmetic.AdditiveSemigroup]].
    */
  given additiveSemigroupToScalaz
    : [X : scalgebra.arithmetic.AdditiveSemigroup as S] => scalaz.Semigroup[X]:
    def append(x: X, y: => X): X = x + y

  /**
    * Derives an [[scalgebra.arithmetic.AdditiveSemigroup]] from a
    * [[scalaz.Semigroup]].
    */
  given additiveSemigroupFromScalaz
    : [X : scalaz.Semigroup as S] => scalgebra.arithmetic.AdditiveSemigroup[X]:
    extension (x: X) override def add(y: X): X = S.append(x, y)
