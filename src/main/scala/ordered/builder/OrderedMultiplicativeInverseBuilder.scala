package com.alecdorrington.scalgebra
package ordered.builder

import com.alecdorrington.scalgebra.evidence.tuple.TupleIsOrderedMultiplicativeInverse
import com.alecdorrington.scalgebra.ordered.OrderedMultiplicativeInverse

/** Methods for constructing [[OrderedMultiplicativeInverse]] type classes. */
trait OrderedMultiplicativeInverseBuilder
  extends OrderedMultiplicativeGroupBuilder, TupleIsOrderedMultiplicativeInverse
