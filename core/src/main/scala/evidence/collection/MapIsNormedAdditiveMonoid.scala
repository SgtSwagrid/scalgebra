package com.alecdorrington.scalgebra
package evidence
package collection

import com.alecdorrington.scalgebra.arithmetic.AdditiveSemigroup
import com.alecdorrington.scalgebra.normed.NormedAdditiveMonoid

/**
  * Evidence that [[Map]] forms a [[NormedAdditiveMonoid]] under pointwise
  * addition, with norm given by the number of keys.
  */
trait MapIsNormedAdditiveMonoid:

  given [X, Y : AdditiveSemigroup as Y] => NormedAdditiveMonoid[Map[X, Y], Int]:

    override def zero: Map[X, Y] = Map.empty

    extension (x: Map[X, Y])

      override def add(y: Map[X, Y]): Map[X, Y] = y.foldLeft(x):
        case (acc, (k, v)) => acc.updated(k, acc.get(k).fold(v)(_ + v))
      override def length: Int = x.size
