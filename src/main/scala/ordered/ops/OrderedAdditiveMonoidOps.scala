package io.github.sgtswagrid.structures
package ordered.ops

import io.github.sgtswagrid.structures.ops.AdditiveMonoidOps
import io.github.sgtswagrid.structures.ordered.OrderedAdditiveMonoid

/** Extension methods for [[OrderedAdditiveMonoid]]. */
trait OrderedAdditiveMonoidOps
  extends AdditiveMonoidOps, OrderedAdditiveSemigroupOps, OrderedAdditiveIdentityOps
