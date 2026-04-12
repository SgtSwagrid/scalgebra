package io.github.sgtswagrid.structures
package ordered.ops

import io.github.sgtswagrid.structures.ops.MultiplicativeGroupOps
import io.github.sgtswagrid.structures.ordered.OrderedMultiplicativeGroup

/** Extension methods for [[OrderedMultiplicativeGroup]]. */
trait OrderedMultiplicativeGroupOps
  extends MultiplicativeGroupOps,
          OrderedEuclideanMonoidOps,
          OrderedMultiplicativeInverseOps
