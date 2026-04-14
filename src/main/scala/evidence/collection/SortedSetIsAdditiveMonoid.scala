package io.github.sgtswagrid.structures
package evidence
package collection

import scala.collection.immutable.SortedSet

/** Evidence that [[SortedSet]] forms an [[AdditiveMonoid]] under set union. */
trait SortedSetIsAdditiveMonoid:

  given [X : Ordering]: AdditiveMonoid[SortedSet[X]] with

    override def zero: SortedSet[X] = SortedSet.empty

    override inline def add(x: SortedSet[X], y: SortedSet[X]): SortedSet[X] =
      x | y
