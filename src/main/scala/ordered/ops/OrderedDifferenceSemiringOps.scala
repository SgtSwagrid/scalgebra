package com.alecdorrington.scalgebra
package ordered.ops

import com.alecdorrington.scalgebra.ops.DifferenceSemiringOps
import com.alecdorrington.scalgebra.ordered.OrderedDifferenceSemiring

/** Extension methods for [[OrderedDifferenceSemiring]]. */
trait OrderedDifferenceSemiringOps
  extends DifferenceSemiringOps, OrderedSemiringOps, OrderedDifferenceMonoidOps
