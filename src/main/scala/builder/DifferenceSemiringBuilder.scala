package io.github.sgtswagrid.structures
package builder

import io.github.sgtswagrid.structures.DifferenceSemiring
import io.github.sgtswagrid.structures.ordered.builder.OrderedDifferenceSemiringBuilder

/** Methods for constructing [[DifferenceSemiring]] type classes. */
trait DifferenceSemiringBuilder
  extends OrderedDifferenceSemiringBuilder, RingBuilder
