package com.alecdorrington.scalgebra
package ordered.builder

import com.alecdorrington.scalgebra.evidence.tuple.TupleIsOrderedAdditiveGroup
import com.alecdorrington.scalgebra.ordered.OrderedAdditiveGroup

/** Methods for constructing [[OrderedAdditiveGroup]] type classes. */
trait OrderedAdditiveGroupBuilder
  extends OrderedRingBuilder, TupleIsOrderedAdditiveGroup
