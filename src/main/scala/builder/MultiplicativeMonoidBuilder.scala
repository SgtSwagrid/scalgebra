package io.github.sgtswagrid.structures
package builder

import io.github.sgtswagrid.structures.MultiplicativeMonoid
import io.github.sgtswagrid.structures.ordered.builder.OrderedMultiplicativeMonoidBuilder

/** Methods for constructing [[MultiplicativeMonoid]] type classes. */
trait MultiplicativeMonoidBuilder
  extends OrderedMultiplicativeMonoidBuilder,
          EuclideanMonoidBuilder,
          SemiringBuilder
