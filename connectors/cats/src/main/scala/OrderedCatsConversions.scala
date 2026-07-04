package com.alecdorrington.scalgebra.connector.cats

import com.alecdorrington.scalgebra as scalgebra

/**
  * Implicit conversions between [[scalgebra.ordered.Ordered]] and
  * [[cats.kernel.Order]].
  */
trait OrderedCatsConversions:

  /** Derives a [[cats.kernel.Order]] from an [[scalgebra.ordered.Ordered]]. */
  given orderedToCats
    : [X : scalgebra.ordered.Ordered as S] => cats.kernel.Order[X]:
    def compare(x: X, y: X): Int = S.compare(x, y)

  /** Derives an [[scalgebra.ordered.Ordered]] from a [[cats.kernel.Order]]. */
  given orderedFromCats
    : [X : cats.kernel.Order as S] => scalgebra.ordered.Ordered[X]:
    override def compare(x: X, y: X): Int = S.compare(x, y)
