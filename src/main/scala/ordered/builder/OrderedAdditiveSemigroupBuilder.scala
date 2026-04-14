package io.github.sgtswagrid.structures
package ordered.builder

import io.github.sgtswagrid.structures.evidence.tuple.TupleIsOrderedAdditiveSemigroup
import io.github.sgtswagrid.structures.ordered.OrderedAdditiveSemigroup

/** Methods for constructing [[OrderedAdditiveSemigroup]] type classes. */
trait OrderedAdditiveSemigroupBuilder
  extends OrderedAdditiveMonoidBuilder, TupleIsOrderedAdditiveSemigroup
