package com.alecdorrington.scalgebra.connector.zioprelude

import com.alecdorrington.{scalgebra as structures}

/**
  * Implicit conversions between [[structures.AdditiveSemigroup]] and
  * [[zio.prelude.Associative]].
  *
  * @note
  *   [[zio.prelude.Associative.combine]] takes both arguments by-name, whereas
  *   [[structures.AdditiveSemigroup.add]] is strict. Both directions evaluate
  *   arguments strictly.
  */
trait AdditiveSemigroupZioPreludeConversions:

  /**
    * Derives a [[zio.prelude.Associative]] from an
    * [[structures.AdditiveSemigroup]].
    */
  given additiveSemigroupToZioPrelude[X : structures.AdditiveSemigroup as S]
    : zio.prelude.Associative[X] with
    def combine(x: => X, y: => X): X = S.add(x, y)

  /**
    * Derives an [[structures.AdditiveSemigroup]] from a
    * [[zio.prelude.Associative]].
    */
  given additiveSemigroupFromZioPrelude[X : zio.prelude.Associative as S]
    : structures.AdditiveSemigroup[X] with
    def add(x: X, y: X): X = S.combine(x, y)
