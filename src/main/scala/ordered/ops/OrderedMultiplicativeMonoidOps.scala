package com.alecdorrington.scalgebra
package ordered.ops

import com.alecdorrington.scalgebra.ops.MultiplicativeMonoidOps
import com.alecdorrington.scalgebra.ordered.OrderedMultiplicativeMonoid

/** Extension methods for [[OrderedMultiplicativeMonoid]]. */
trait OrderedMultiplicativeMonoidOps
  extends MultiplicativeMonoidOps,
          OrderedMultiplicativeSemigroupOps,
          OrderedMultiplicativeIdentityOps
