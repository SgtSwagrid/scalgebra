package io.github.sgtswagrid.structures
package ordered.ops

import io.github.sgtswagrid.structures.ops.DifferenceSemiringOps
import io.github.sgtswagrid.structures.ordered.OrderedDifferenceSemiring

/** Extension methods for [[OrderedDifferenceSemiring]]. */
trait OrderedDifferenceSemiringOps
  extends DifferenceSemiringOps, OrderedSemiringOps, OrderedDifferenceMonoidOps
