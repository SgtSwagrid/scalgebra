package com.alecdorrington.scalgebra
package ordered.builder

import com.alecdorrington.scalgebra.evidence.tuple.TupleIsOrderedSemiring
import com.alecdorrington.scalgebra.ordered.OrderedSemiring

/** Methods for constructing [[OrderedSemiring]] type classes. */
trait OrderedSemiringBuilder
  extends OrderedDifferenceSemiringBuilder,
          OrderedSemifieldBuilder,
          TupleIsOrderedSemiring
