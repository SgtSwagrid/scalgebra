package com.alecdorrington.scalgebra
package ordered.builder

import com.alecdorrington.scalgebra.evidence.tuple.TupleIsOrderedMultiplicativeGroup
import com.alecdorrington.scalgebra.ordered.OrderedMultiplicativeGroup

/** Methods for constructing [[OrderedMultiplicativeGroup]] type classes. */
trait OrderedMultiplicativeGroupBuilder
  extends OrderedSemifieldBuilder, TupleIsOrderedMultiplicativeGroup
