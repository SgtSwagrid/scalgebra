package com.alecdorrington.scalgebra
package ordered.ops

import com.alecdorrington.scalgebra.ops.SemifieldOps
import com.alecdorrington.scalgebra.ordered.OrderedSemifield

/** Extension methods for [[OrderedSemifield]]. */
trait OrderedSemifieldOps
  extends SemifieldOps, OrderedSemiringOps, OrderedMultiplicativeGroupOps
