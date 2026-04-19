package com.alecdorrington.scalgebra
package ordered.builder

import com.alecdorrington.scalgebra.evidence.numeric.{
  BigIntIsOrderedEuclideanRing, ByteIsOrderedEuclideanRing,
  IntegralIsOrderedEuclideanRing, IntIsOrderedEuclideanRing,
  LongIsOrderedEuclideanRing, ShortIsOrderedEuclideanRing,
}
import com.alecdorrington.scalgebra.evidence.tuple.TupleIsOrderedEuclideanRing
import com.alecdorrington.scalgebra.ordered.OrderedEuclideanRing

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
