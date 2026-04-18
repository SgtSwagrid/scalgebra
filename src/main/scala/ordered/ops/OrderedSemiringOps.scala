package com.alecdorrington.scalgebra
package ordered.ops

import com.alecdorrington.scalgebra.ops.SemiringOps
import com.alecdorrington.scalgebra.ordered.OrderedSemiring

/** Extension methods for [[OrderedSemiring]]. */
trait OrderedSemiringOps
  extends SemiringOps, OrderedAdditiveMonoidOps, OrderedMultiplicativeMonoidOps
