package com.alecdorrington.scalgebra
package ordered.ops

import com.alecdorrington.scalgebra.ops.MultiplicativeSemigroupOps
import com.alecdorrington.scalgebra.ordered.OrderedMultiplicativeSemigroup

/** Extension methods for [[OrderedMultiplicativeSemigroup]]. */
trait OrderedMultiplicativeSemigroupOps
  extends MultiplicativeSemigroupOps, OrderingOps
