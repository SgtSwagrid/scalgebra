package io.github.sgtswagrid.structures
package ordered.builder

import io.github.sgtswagrid.structures.ordered.OrderedAdditiveMonoid

/** Methods for constructing [[OrderedAdditiveMonoid]] type classes. */
trait OrderedAdditiveMonoidBuilder
  extends OrderedDifferenceMonoidBuilder, OrderedSemiringBuilder
