package io.github.sgtswagrid.structures
package ordered.builder

import io.github.sgtswagrid.structures.evidence.tuple.TupleIsOrderedDifferenceMonoid
import io.github.sgtswagrid.structures.ordered.OrderedDifferenceMonoid

/** Methods for constructing [[OrderedDifferenceMonoid]] type classes. */
trait OrderedDifferenceMonoidBuilder
  extends OrderedAdditiveGroupBuilder,
          OrderedDifferenceSemiringBuilder,
          TupleIsOrderedDifferenceMonoid
