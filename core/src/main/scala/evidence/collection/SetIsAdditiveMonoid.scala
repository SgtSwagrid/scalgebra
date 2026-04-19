package com.alecdorrington.scalgebra
package evidence
package collection

/** Evidence that [[Set]] forms an [[AdditiveMonoid]] under set union. */
trait SetIsAdditiveMonoid:

  given [X]: AdditiveMonoid[Set[X]] with

    override def zero: Set[X]                             = Set.empty
    override inline def add(x: Set[X], y: Set[X]): Set[X] = x | y
