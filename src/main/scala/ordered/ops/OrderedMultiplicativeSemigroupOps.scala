package io.github.sgtswagrid.structures
package ordered.ops

import io.github.sgtswagrid.structures.ops.MultiplicativeSemigroupOps
import io.github.sgtswagrid.structures.ordered.OrderedMultiplicativeSemigroup

/** Extension methods for [[OrderedMultiplicativeSemigroup]]. */
trait OrderedMultiplicativeSemigroupOps
  extends MultiplicativeSemigroupOps, OrderingOps
