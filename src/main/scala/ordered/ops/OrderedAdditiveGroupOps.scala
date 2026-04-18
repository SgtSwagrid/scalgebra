package com.alecdorrington.scalgebra
package ordered.ops

import com.alecdorrington.scalgebra.ops.AdditiveGroupOps
import com.alecdorrington.scalgebra.ordered.OrderedAdditiveGroup

/** Extension methods for [[OrderedAdditiveGroup]]. */
trait OrderedAdditiveGroupOps
  extends AdditiveGroupOps,
          OrderedDifferenceMonoidOps,
          OrderedAdditiveInverseOps
