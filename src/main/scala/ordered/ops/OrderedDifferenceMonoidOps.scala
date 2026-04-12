package io.github.sgtswagrid.structures
package ordered.ops

import io.github.sgtswagrid.structures.ops.DifferenceMonoidOps
import io.github.sgtswagrid.structures.ordered.OrderedDifferenceMonoid

/** Extension methods for [[OrderedDifferenceMonoid]]. */
trait OrderedDifferenceMonoidOps
  extends DifferenceMonoidOps, OrderedAdditiveMonoidOps
