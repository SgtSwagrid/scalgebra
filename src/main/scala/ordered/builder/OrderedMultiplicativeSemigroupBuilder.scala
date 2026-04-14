package io.github.sgtswagrid.structures
package ordered.builder

import io.github.sgtswagrid.structures.evidence.tuple.TupleIsOrderedMultiplicativeSemigroup
import io.github.sgtswagrid.structures.ordered.OrderedMultiplicativeSemigroup

/** Methods for constructing [[OrderedMultiplicativeSemigroup]] type classes. */
trait OrderedMultiplicativeSemigroupBuilder
  extends OrderedMultiplicativeMonoidBuilder,
          TupleIsOrderedMultiplicativeSemigroup
