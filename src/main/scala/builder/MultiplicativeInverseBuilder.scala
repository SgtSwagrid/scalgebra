package io.github.sgtswagrid.structures
package builder

import io.github.sgtswagrid.structures.MultiplicativeInverse
import io.github.sgtswagrid.structures.ordered.builder.OrderedMultiplicativeInverseBuilder

/** Methods for constructing [[MultiplicativeInverse]] type classes. */
trait MultiplicativeInverseBuilder
  extends OrderedMultiplicativeInverseBuilder, MultiplicativeGroupBuilder
