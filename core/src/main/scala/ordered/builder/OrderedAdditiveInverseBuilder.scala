package com.alecdorrington.scalgebra
package ordered.builder

import com.alecdorrington.scalgebra.evidence.tuple.TupleIsOrderedAdditiveInverse
import com.alecdorrington.scalgebra.ordered.OrderedAdditiveInverse

/** Methods for constructing [[OrderedAdditiveInverse]] type classes. */
trait OrderedAdditiveInverseBuilder
  extends OrderedAdditiveGroupBuilder, TupleIsOrderedAdditiveInverse
