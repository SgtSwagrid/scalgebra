package io.github.sgtswagrid.structures
package builder

import io.github.sgtswagrid.structures.AdditiveMonoid
import io.github.sgtswagrid.structures.ordered.builder.OrderedAdditiveMonoidBuilder

/** Methods for constructing [[AdditiveMonoid]] type classes. */
trait AdditiveMonoidBuilder
  extends OrderedAdditiveMonoidBuilder, DifferenceMonoidBuilder, SemiringBuilder
