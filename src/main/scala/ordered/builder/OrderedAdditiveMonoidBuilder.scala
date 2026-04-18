package com.alecdorrington.scalgebra
package ordered.builder

import com.alecdorrington.scalgebra.evidence.tuple.TupleIsOrderedAdditiveMonoid
import com.alecdorrington.scalgebra.ordered.OrderedAdditiveMonoid

/** Methods for constructing [[OrderedAdditiveMonoid]] type classes. */
trait OrderedAdditiveMonoidBuilder
  extends OrderedDifferenceMonoidBuilder,
          OrderedSemiringBuilder,
          TupleIsOrderedAdditiveMonoid
