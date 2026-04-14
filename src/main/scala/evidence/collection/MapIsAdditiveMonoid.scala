package io.github.sgtswagrid.structures
package evidence
package collection

/**
  * Evidence that [[Map]] forms an [[AdditiveMonoid]] under pointwise addition,
  * provided the value type has an [[AdditiveSemigroup]] instance.
  *
  * Keys present in only one map are carried over as-is; keys present in both
  * are combined using the value semigroup's [[AdditiveSemigroup.add]].
  */
trait MapIsAdditiveMonoid:

  given [X, Y : AdditiveSemigroup as Y]: AdditiveMonoid[Map[X, Y]] with

    override def zero: Map[X, Y] = Map.empty

    override def add(x: Map[X, Y], y: Map[X, Y]): Map[X, Y] = y.foldLeft(x):
      case (acc, (k, v)) => acc.updated(k, acc.get(k).fold(v)(Y.add(_, v)))
