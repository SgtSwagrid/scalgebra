package io.github.sgtswagrid.structures
package ordered.builder

import io.github.sgtswagrid.structures.evidence.numeric.{
  BooleanIsOrderedRing, NumericIsOrderedRing,
}
import io.github.sgtswagrid.structures.evidence.tuple.TupleIsOrderedRing
import io.github.sgtswagrid.structures.ordered.OrderedRing

/** Methods for constructing [[OrderedRing]] type classes. */
trait OrderedRingBuilder
  extends OrderedEuclideanRingBuilder,
          BooleanIsOrderedRing,
          NumericIsOrderedRing,
          TupleIsOrderedRing
