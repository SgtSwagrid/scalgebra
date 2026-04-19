package com.alecdorrington.scalgebra.connector.scalaz

import com.alecdorrington.{scalgebra as structures}

/**
  * Implicit conversions between [[structures.AdditiveSemigroup]] and
  * [[scalaz.Semigroup]].
  *
  * @note
  *   [[scalaz.Semigroup.append]] takes its second argument by-name, whereas
  *   [[structures.AdditiveSemigroup.add]] is strict. Both directions evaluate
  *   arguments strictly.
  */
trait AdditiveSemigroupScalazConversions:

  /** Derives a [[scalaz.Semigroup]] from an [[structures.AdditiveSemigroup]]. */
  given additiveSemigroupToScalaz[X : structures.AdditiveSemigroup as S]
    : scalaz.Semigroup[X] with
    def append(x: X, y: => X): X = S.add(x, y)

  /** Derives an [[structures.AdditiveSemigroup]] from a [[scalaz.Semigroup]]. */
  given additiveSemigroupFromScalaz[X : scalaz.Semigroup as S]
    : structures.AdditiveSemigroup[X] with
    def add(x: X, y: X): X = S.append(x, y)
