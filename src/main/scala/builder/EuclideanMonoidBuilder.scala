package io.github.sgtswagrid.structures
package builder

import io.github.sgtswagrid.structures.EuclideanMonoid
import io.github.sgtswagrid.structures.ordered.builder.OrderedEuclideanMonoidBuilder

/** Methods for constructing [[EuclideanMonoid]] type classes. */
trait EuclideanMonoidBuilder
  extends OrderedEuclideanMonoidBuilder,
          MultiplicativeGroupBuilder,
          EuclideanRingBuilder
