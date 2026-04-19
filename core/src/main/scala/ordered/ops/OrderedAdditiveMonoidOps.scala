package com.alecdorrington.scalgebra
package ordered.ops

import com.alecdorrington.scalgebra.ops.AdditiveMonoidOps
import com.alecdorrington.scalgebra.ordered.OrderedAdditiveMonoid

/** Extension methods for [[OrderedAdditiveMonoid]]. */
trait OrderedAdditiveMonoidOps
  extends AdditiveMonoidOps,
          OrderedAdditiveSemigroupOps,
          OrderedAdditiveIdentityOps
