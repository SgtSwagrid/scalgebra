package com.alecdorrington.scalgebra
package ordered.builder

import com.alecdorrington.scalgebra.evidence.tuple.TupleIsOrderedDifferenceSemiring
import com.alecdorrington.scalgebra.ordered.OrderedDifferenceSemiring

/** Methods for constructing [[OrderedDifferenceSemiring]] type classes. */
trait OrderedDifferenceSemiringBuilder
  extends OrderedDifferenceSemifieldBuilder,
          OrderedRingBuilder,
          TupleIsOrderedDifferenceSemiring
