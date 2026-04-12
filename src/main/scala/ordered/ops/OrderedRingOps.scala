package io.github.sgtswagrid.structures
package ordered.ops

import io.github.sgtswagrid.structures.ops.RingOps
import io.github.sgtswagrid.structures.ordered.OrderedRing

/** Extension methods for [[OrderedRing]]. */
trait OrderedRingOps
  extends RingOps, OrderedAdditiveGroupOps, OrderedDifferenceSemiringOps
