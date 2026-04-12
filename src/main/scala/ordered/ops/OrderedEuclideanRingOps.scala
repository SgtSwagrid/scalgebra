package io.github.sgtswagrid.structures
package ordered.ops

import io.github.sgtswagrid.structures.ops.EuclideanRingOps
import io.github.sgtswagrid.structures.ordered.OrderedEuclideanRing

/** Extension methods for [[OrderedEuclideanRing]]. */
trait OrderedEuclideanRingOps
  extends EuclideanRingOps, OrderedRingOps, OrderedEuclideanMonoidOps
