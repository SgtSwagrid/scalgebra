package com.alecdorrington.scalgebra
package ordered.ops

import com.alecdorrington.scalgebra.ops.DifferenceMonoidOps
import com.alecdorrington.scalgebra.ordered.OrderedDifferenceMonoid

/** Extension methods for [[OrderedDifferenceMonoid]]. */
trait OrderedDifferenceMonoidOps
  extends DifferenceMonoidOps, OrderedAdditiveMonoidOps
