package io.github.sgtswagrid.structures
package ordered.builder

import io.github.sgtswagrid.structures.ordered.OrderedSemiring

/** Methods for constructing [[OrderedSemiring]] type classes. */
trait OrderedSemiringBuilder
  extends OrderedDifferenceSemiringBuilder, OrderedSemifieldBuilder
