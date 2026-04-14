package io.github.sgtswagrid.structures
package ordered.builder

import io.github.sgtswagrid.structures.evidence.numeric.{
  BigIntIsOrderedEuclideanRing, ByteIsOrderedEuclideanRing,
  IntegralIsOrderedEuclideanRing, IntIsOrderedEuclideanRing,
  LongIsOrderedEuclideanRing, ShortIsOrderedEuclideanRing,
}
import io.github.sgtswagrid.structures.evidence.tuple.TupleIsOrderedEuclideanRing
import io.github.sgtswagrid.structures.ordered.OrderedEuclideanRing

/** Methods for constructing [[OrderedEuclideanRing]] type classes. */
trait OrderedEuclideanRingBuilder
  extends OrderedFieldBuilder,
          ByteIsOrderedEuclideanRing,
          ShortIsOrderedEuclideanRing,
          IntIsOrderedEuclideanRing,
          LongIsOrderedEuclideanRing,
          BigIntIsOrderedEuclideanRing,
          IntegralIsOrderedEuclideanRing,
          TupleIsOrderedEuclideanRing
