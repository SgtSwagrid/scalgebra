package com.alecdorrington.scalgebra
package ordered.builder

import com.alecdorrington.scalgebra.evidence.tuple.TupleIsOrderedDifferenceMonoid
import com.alecdorrington.scalgebra.ordered.OrderedDifferenceMonoid

/** Methods for constructing [[OrderedDifferenceMonoid]] type classes. */
trait OrderedDifferenceMonoidBuilder
  extends OrderedAdditiveGroupBuilder,
          OrderedDifferenceSemiringBuilder,
          TupleIsOrderedDifferenceMonoid
