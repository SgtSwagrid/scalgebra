package com.alecdorrington.scalgebra
package ordered.builder

import com.alecdorrington.scalgebra.evidence.tuple.TupleIsOrderedSemifield
import com.alecdorrington.scalgebra.ordered.OrderedSemifield

/** Methods for constructing [[OrderedSemifield]] type classes. */
trait OrderedSemifieldBuilder
  extends OrderedDifferenceSemifieldBuilder, TupleIsOrderedSemifield
