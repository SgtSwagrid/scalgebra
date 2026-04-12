package io.github.sgtswagrid.structures
package ordered.ops

import io.github.sgtswagrid.structures.ops.EuclideanMonoidOps
import io.github.sgtswagrid.structures.ordered.OrderedEuclideanMonoid

/** Extension methods for [[OrderedEuclideanMonoid]]. */
trait OrderedEuclideanMonoidOps
  extends EuclideanMonoidOps, OrderedMultiplicativeMonoidOps
