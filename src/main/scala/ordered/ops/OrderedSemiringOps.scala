package io.github.sgtswagrid.structures
package ordered.ops

import io.github.sgtswagrid.structures.ops.SemiringOps
import io.github.sgtswagrid.structures.ordered.OrderedSemiring

/** Extension methods for [[OrderedSemiring]]. */
trait OrderedSemiringOps
  extends SemiringOps, OrderedAdditiveMonoidOps, OrderedMultiplicativeMonoidOps
