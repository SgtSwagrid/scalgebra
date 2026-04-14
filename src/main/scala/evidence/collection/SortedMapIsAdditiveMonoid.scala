package io.github.sgtswagrid.structures
package evidence
package collection

import scala.collection.immutable.SortedMap

/**
  * Evidence that [[SortedMap]] forms an [[AdditiveMonoid]] under pointwise
  * addition, provided the value type has an [[AdditiveSemigroup]] instance.
  *
  * Keys present in only one map are carried over as-is; keys present in both
  * are combined using the value semigroup's [[AdditiveSemigroup.add]].
  */
trait SortedMapIsAdditiveMonoid:

  given [X : Ordering, Y : AdditiveSemigroup as Y]
    : AdditiveMonoid[SortedMap[X, Y]] with

    override def zero: SortedMap[X, Y] = SortedMap.empty

    override def add(x: SortedMap[X, Y], y: SortedMap[X, Y]): SortedMap[X, Y] =
      y.foldLeft(x):
        case (acc, (k, v)) => acc.updated(k, acc.get(k).fold(v)(Y.add(_, v)))
