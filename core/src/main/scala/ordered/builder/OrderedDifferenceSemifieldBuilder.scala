package com.alecdorrington.scalgebra
package ordered.builder

import com.alecdorrington.scalgebra.evidence.tuple.TupleIsOrderedDifferenceSemifield
import com.alecdorrington.scalgebra.ordered.OrderedDifferenceSemifield

/** Methods for constructing [[OrderedDifferenceSemifield]] type classes. */
trait OrderedDifferenceSemifieldBuilder
  extends OrderedFieldBuilder, TupleIsOrderedDifferenceSemifield
