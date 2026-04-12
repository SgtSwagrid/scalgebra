package io.github.sgtswagrid.structures
package ordered.ops

import io.github.sgtswagrid.structures.ops.MultiplicativeMonoidOps
import io.github.sgtswagrid.structures.ordered.OrderedMultiplicativeMonoid

/** Extension methods for [[OrderedMultiplicativeMonoid]]. */
trait OrderedMultiplicativeMonoidOps
  extends MultiplicativeMonoidOps,
          OrderedMultiplicativeSemigroupOps,
          OrderedMultiplicativeIdentityOps
