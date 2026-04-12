package io.github.sgtswagrid.structures
package builder

import io.github.sgtswagrid.structures.AdditiveSemigroup
import io.github.sgtswagrid.structures.ordered.builder.OrderedAdditiveSemigroupBuilder

/** Methods for constructing [[AdditiveSemigroup]] type classes. */
trait AdditiveSemigroupBuilder
  extends OrderedAdditiveSemigroupBuilder, AdditiveMonoidBuilder
