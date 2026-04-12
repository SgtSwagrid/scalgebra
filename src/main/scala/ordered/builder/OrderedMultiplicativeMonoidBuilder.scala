package io.github.sgtswagrid.structures
package ordered.builder

import io.github.sgtswagrid.structures.ordered.OrderedMultiplicativeMonoid

/** Methods for constructing [[OrderedMultiplicativeMonoid]] type classes. */
trait OrderedMultiplicativeMonoidBuilder
  extends OrderedEuclideanMonoidBuilder, OrderedSemiringBuilder
