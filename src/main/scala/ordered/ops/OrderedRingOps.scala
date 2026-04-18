package com.alecdorrington.scalgebra
package ordered.ops

import com.alecdorrington.scalgebra.ops.RingOps
import com.alecdorrington.scalgebra.ordered.OrderedRing

/** Extension methods for [[OrderedRing]]. */
trait OrderedRingOps
  extends RingOps, OrderedAdditiveGroupOps, OrderedDifferenceSemiringOps
