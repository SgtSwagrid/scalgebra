package io.github.sgtswagrid.structures
package builder

import io.github.sgtswagrid.structures.DifferenceMonoid
import io.github.sgtswagrid.structures.ordered.builder.OrderedDifferenceMonoidBuilder

/** Methods for constructing [[DifferenceMonoid]] type classes. */
trait DifferenceMonoidBuilder
  extends OrderedDifferenceMonoidBuilder,
          AdditiveGroupBuilder,
          DifferenceSemiringBuilder
