package io.github.sgtswagrid.structures
package ordered.ops

import io.github.sgtswagrid.structures.ops.AdditiveGroupOps
import io.github.sgtswagrid.structures.ordered.OrderedAdditiveGroup

/** Extension methods for [[OrderedAdditiveGroup]]. */
trait OrderedAdditiveGroupOps
  extends AdditiveGroupOps,
          OrderedDifferenceMonoidOps,
          OrderedAdditiveInverseOps
