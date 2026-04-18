package com.alecdorrington.scalgebra
package ordered.ops

import com.alecdorrington.scalgebra.ops.EuclideanMonoidOps
import com.alecdorrington.scalgebra.ordered.OrderedEuclideanMonoid

/** Extension methods for [[OrderedEuclideanMonoid]]. */
trait OrderedEuclideanMonoidOps
  extends EuclideanMonoidOps, OrderedMultiplicativeMonoidOps
