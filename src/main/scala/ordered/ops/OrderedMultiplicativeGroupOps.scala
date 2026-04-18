package com.alecdorrington.scalgebra
package ordered.ops

import com.alecdorrington.scalgebra.ops.MultiplicativeGroupOps
import com.alecdorrington.scalgebra.ordered.OrderedMultiplicativeGroup

/** Extension methods for [[OrderedMultiplicativeGroup]]. */
trait OrderedMultiplicativeGroupOps
  extends MultiplicativeGroupOps,
          OrderedEuclideanMonoidOps,
          OrderedMultiplicativeInverseOps
