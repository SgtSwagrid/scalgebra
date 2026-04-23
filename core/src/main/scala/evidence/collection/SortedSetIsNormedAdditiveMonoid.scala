package com.alecdorrington.scalgebra
package evidence
package collection

import com.alecdorrington.scalgebra.normed.NormedAdditiveMonoid
import scala.collection.immutable.SortedSet

/**
  * Evidence that [[SortedSet]] forms a [[NormedAdditiveMonoid]] under set
  * union, with norm given by the set size.
  */
trait SortedSetIsNormedAdditiveMonoid:

  given [X : Ordering]: NormedAdditiveMonoid[SortedSet[X], Int] with

    override def zero: SortedSet[X] = SortedSet.empty

    override inline def add(x: SortedSet[X], y: SortedSet[X]): SortedSet[X] =
      x | y

    override inline def norm(x: SortedSet[X]): Int = x.size
