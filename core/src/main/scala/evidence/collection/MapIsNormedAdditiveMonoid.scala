package com.alecdorrington.scalgebra
package evidence
package collection

import com.alecdorrington.scalgebra.normed.NormedAdditiveMonoid

/**
  * Evidence that [[Map]] forms a [[NormedAdditiveMonoid]] under pointwise
  * addition, with norm given by the number of keys.
  */
trait MapIsNormedAdditiveMonoid:

  given [X, Y : AdditiveSemigroup as Y]: NormedAdditiveMonoid[Map[X, Y], Int]
  with

    override def zero: Map[X, Y] = Map.empty

    override def add(x: Map[X, Y], y: Map[X, Y]): Map[X, Y] = y.foldLeft(x):
      case (acc, (k, v)) => acc.updated(k, acc.get(k).fold(v)(Y.add(_, v)))

    override inline def norm(x: Map[X, Y]): Int = x.size
