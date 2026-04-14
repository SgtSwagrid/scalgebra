package io.github.sgtswagrid.structures
package ordered.builder

import io.github.sgtswagrid.structures.evidence.tuple.TupleIsOrderedDifferenceSemiring
import io.github.sgtswagrid.structures.ordered.OrderedDifferenceSemiring

/** Methods for constructing [[OrderedDifferenceSemiring]] type classes. */
trait OrderedDifferenceSemiringBuilder
  extends OrderedRingBuilder, TupleIsOrderedDifferenceSemiring
