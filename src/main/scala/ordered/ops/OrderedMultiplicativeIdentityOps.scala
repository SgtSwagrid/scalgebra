package com.alecdorrington.scalgebra
package ordered.ops

import com.alecdorrington.scalgebra.ops.MultiplicativeIdentityOps
import com.alecdorrington.scalgebra.ordered.OrderedMultiplicativeIdentity

/** Extension methods for [[OrderedMultiplicativeIdentity]]. */
trait OrderedMultiplicativeIdentityOps
  extends MultiplicativeIdentityOps, OrderingOps
