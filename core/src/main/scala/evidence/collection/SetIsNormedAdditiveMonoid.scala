package com.alecdorrington.scalgebra
package evidence
package collection

import com.alecdorrington.scalgebra.normed.NormedAdditiveMonoid

/**
  * Evidence that [[Set]] forms a [[NormedAdditiveMonoid]] under set union, with
  * norm given by the set size.
  */
trait SetIsNormedAdditiveMonoid:

  given [X] => NormedAdditiveMonoid[Set[X], Int]:

    override def zero: Set[X] = Set.empty

    extension (x: Set[X])

      override def add(y: Set[X]): Set[X] = x | y
      override def length: Int            = x.size
