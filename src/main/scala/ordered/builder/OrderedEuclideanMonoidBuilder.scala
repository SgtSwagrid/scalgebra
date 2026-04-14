package io.github.sgtswagrid.structures
package ordered.builder

import io.github.sgtswagrid.structures.evidence.tuple.TupleIsOrderedEuclideanMonoid
import io.github.sgtswagrid.structures.ordered.OrderedEuclideanMonoid

/** Methods for constructing [[OrderedEuclideanMonoid]] type classes. */
trait OrderedEuclideanMonoidBuilder
  extends OrderedMultiplicativeGroupBuilder,
          OrderedEuclideanRingBuilder,
          TupleIsOrderedEuclideanMonoid
