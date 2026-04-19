package com.alecdorrington.scalgebra
package ordered.builder

import com.alecdorrington.scalgebra.evidence.tuple.TupleIsOrderedMultiplicativeSemigroup
import com.alecdorrington.scalgebra.ordered.OrderedMultiplicativeSemigroup

/** Methods for constructing [[OrderedMultiplicativeSemigroup]] type classes. */
trait OrderedMultiplicativeSemigroupBuilder
  extends OrderedMultiplicativeMonoidBuilder,
          TupleIsOrderedMultiplicativeSemigroup
