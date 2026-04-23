package com.alecdorrington.scalgebra
package evidence
package collection

import com.alecdorrington.scalgebra.normed.NormedAdditiveMonoid
import scala.collection.immutable.SortedMap

/**
  * Evidence that [[SortedMap]] forms a [[NormedAdditiveMonoid]] under pointwise
  * addition, with norm given by the number of keys.
  */
trait SortedMapIsNormedAdditiveMonoid:

  given [X : Ordering, Y : AdditiveSemigroup as Y]
    : NormedAdditiveMonoid[SortedMap[X, Y], Int] with

    override def zero: SortedMap[X, Y] = SortedMap.empty

    override def add(x: SortedMap[X, Y], y: SortedMap[X, Y]): SortedMap[X, Y] =
      y.foldLeft(x):
        case (acc, (k, v)) => acc.updated(k, acc.get(k).fold(v)(Y.add(_, v)))

    override inline def norm(x: SortedMap[X, Y]): Int = x.size
