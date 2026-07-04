package com.alecdorrington.scalgebra.connector.spire

import com.alecdorrington.scalgebra as scalgebra
import spire.algebra

/**
  * Implicit conversion from [[spire.algebra.IsReal]] to
  * [[scalgebra.archimedean.Archimedean]].
  *
  * @note
  *   Only the [[spire.algebra.IsReal]] → [[scalgebra.archimedean.Archimedean]]
  *   direction is provided. The reverse requires an embedding into the real
  *   numbers ([[spire.algebra.IsReal.toDouble]]), which has no counterpart in
  *   [[scalgebra.archimedean.Archimedean]].
  */
trait ArchimedeanSpireConversions:

  /**
    * Derives an [[scalgebra.archimedean.Archimedean]] from a
    * [[spire.algebra.IsReal]].
    */
  given archimedeanFromSpire
    : [X : algebra.IsReal as S] => scalgebra.archimedean.Archimedean[X]:

    override def compare(x: X, y: X): Int = S.compare(x, y)

    extension (x: X)

      override def floor: X = S.floor(x)
      override def ceil: X  = S.ceil(x)
