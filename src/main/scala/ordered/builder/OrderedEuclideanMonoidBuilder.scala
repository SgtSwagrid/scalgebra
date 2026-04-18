package com.alecdorrington.scalgebra
package ordered.builder

import com.alecdorrington.scalgebra.evidence.tuple.TupleIsOrderedEuclideanMonoid
import com.alecdorrington.scalgebra.ordered.OrderedEuclideanMonoid

/** Methods for constructing [[OrderedEuclideanMonoid]] type classes. */
trait OrderedEuclideanMonoidBuilder
  extends OrderedMultiplicativeGroupBuilder,
          OrderedEuclideanRingBuilder,
          TupleIsOrderedEuclideanMonoid
