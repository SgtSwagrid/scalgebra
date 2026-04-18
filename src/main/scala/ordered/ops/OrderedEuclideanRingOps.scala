package com.alecdorrington.scalgebra
package ordered.ops

import com.alecdorrington.scalgebra.ops.EuclideanRingOps
import com.alecdorrington.scalgebra.ordered.OrderedEuclideanRing

/** Extension methods for [[OrderedEuclideanRing]]. */
trait OrderedEuclideanRingOps
  extends EuclideanRingOps, OrderedRingOps, OrderedEuclideanMonoidOps
