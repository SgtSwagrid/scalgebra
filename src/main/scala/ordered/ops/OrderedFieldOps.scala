package io.github.sgtswagrid.structures
package ordered.ops

import io.github.sgtswagrid.structures.ops.FieldOps
import io.github.sgtswagrid.structures.ordered.OrderedField

/** Extension methods for [[OrderedField]]. */
trait OrderedFieldOps
  extends FieldOps, OrderedEuclideanRingOps, OrderedMultiplicativeGroupOps
