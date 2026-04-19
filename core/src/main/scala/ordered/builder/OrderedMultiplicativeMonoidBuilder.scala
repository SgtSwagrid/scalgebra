package com.alecdorrington.scalgebra
package ordered.builder

import com.alecdorrington.scalgebra.evidence.tuple.TupleIsOrderedMultiplicativeMonoid
import com.alecdorrington.scalgebra.ordered.OrderedMultiplicativeMonoid

/** Methods for constructing [[OrderedMultiplicativeMonoid]] type classes. */
trait OrderedMultiplicativeMonoidBuilder
  extends OrderedEuclideanMonoidBuilder,
          OrderedSemiringBuilder,
          TupleIsOrderedMultiplicativeMonoid
