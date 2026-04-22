package com.alecdorrington.scalgebra
package ordered.ops

import com.alecdorrington.scalgebra.ops.DifferenceSemifieldOps
import com.alecdorrington.scalgebra.ordered.OrderedDifferenceSemifield

/** Extension methods for [[OrderedDifferenceSemifield]]. */
trait OrderedDifferenceSemifieldOps
  extends DifferenceSemifieldOps,
          OrderedDifferenceSemiringOps,
          OrderedSemifieldOps
