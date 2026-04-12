package io.github.sgtswagrid.structures
package ordered.builder

import io.github.sgtswagrid.structures.evidence.{
  BigIntIsOrderedEuclideanRing, IntIsOrderedEuclideanRing,
  LongIsOrderedEuclideanRing,
}
import io.github.sgtswagrid.structures.ordered.OrderedEuclideanRing

/** Methods for constructing [[OrderedEuclideanRing]] type classes. */
trait OrderedEuclideanRingBuilder
  extends OrderedFieldBuilder,
          IntIsOrderedEuclideanRing,
          LongIsOrderedEuclideanRing,
          BigIntIsOrderedEuclideanRing
