package io.github.sgtswagrid.structures
package builder

import io.github.sgtswagrid.structures.AdditiveInverse
import io.github.sgtswagrid.structures.ordered.builder.OrderedAdditiveInverseBuilder

/** Methods for constructing [[AdditiveInverse]] type classes. */
trait AdditiveInverseBuilder
  extends OrderedAdditiveInverseBuilder, AdditiveGroupBuilder
