package io.github.sgtswagrid.structures
package builder

import io.github.sgtswagrid.structures.Semiring
import io.github.sgtswagrid.structures.ordered.builder.OrderedSemiringBuilder

/** Methods for constructing [[Semiring]] type classes. */
trait SemiringBuilder
  extends OrderedSemiringBuilder, DifferenceSemiringBuilder, SemifieldBuilder
