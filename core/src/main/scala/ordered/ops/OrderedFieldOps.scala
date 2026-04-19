package com.alecdorrington.scalgebra
package ordered.ops

import com.alecdorrington.scalgebra.ops.FieldOps
import com.alecdorrington.scalgebra.ordered.OrderedField

/** Extension methods for [[OrderedField]]. */
trait OrderedFieldOps
  extends FieldOps, OrderedEuclideanRingOps, OrderedMultiplicativeGroupOps
