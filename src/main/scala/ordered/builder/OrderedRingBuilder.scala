package com.alecdorrington.scalgebra
package ordered.builder

import com.alecdorrington.scalgebra.evidence.numeric.{
  BooleanIsOrderedRing, NumericIsOrderedRing,
}
import com.alecdorrington.scalgebra.evidence.tuple.TupleIsOrderedRing
import com.alecdorrington.scalgebra.ordered.OrderedRing

/** Methods for constructing [[OrderedRing]] type classes. */
trait OrderedRingBuilder
  extends OrderedEuclideanRingBuilder,
          BooleanIsOrderedRing,
          NumericIsOrderedRing,
          TupleIsOrderedRing
