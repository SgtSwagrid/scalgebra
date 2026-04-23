package com.alecdorrington.scalgebra
package evidence
package collection

import com.alecdorrington.scalgebra.normed.NormedAdditiveMonoid

/**
  * Evidence that [[Set]] forms a [[NormedAdditiveMonoid]] under set union, with
  * norm given by the set size.
  */
trait SetIsNormedAdditiveMonoid:

  given [X]: NormedAdditiveMonoid[Set[X], Int] with

    override def zero: Set[X]                             = Set.empty
    override inline def add(x: Set[X], y: Set[X]): Set[X] = x | y
    override inline def norm(x: Set[X]): Int              = x.size
