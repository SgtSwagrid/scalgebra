package com.alecdorrington.scalgebra
package ordered.builder

import com.alecdorrington.scalgebra.evidence.tuple.TupleIsOrderedAdditiveSemigroup
import com.alecdorrington.scalgebra.ordered.OrderedAdditiveSemigroup

/** Methods for constructing [[OrderedAdditiveSemigroup]] type classes. */
trait OrderedAdditiveSemigroupBuilder
  extends OrderedAdditiveMonoidBuilder, TupleIsOrderedAdditiveSemigroup
