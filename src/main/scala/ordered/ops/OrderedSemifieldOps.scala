package io.github.sgtswagrid.structures
package ordered.ops

import io.github.sgtswagrid.structures.ops.SemifieldOps
import io.github.sgtswagrid.structures.ordered.OrderedSemifield

/** Extension methods for [[OrderedSemifield]]. */
trait OrderedSemifieldOps
  extends SemifieldOps, OrderedSemiringOps, OrderedMultiplicativeGroupOps
