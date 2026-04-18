package com.alecdorrington.scalgebra
package builder

import com.alecdorrington.scalgebra.Ring
import com.alecdorrington.scalgebra.evidence.function.FunctionIsRing
import com.alecdorrington.scalgebra.evidence.future.FutureIsRing
import com.alecdorrington.scalgebra.evidence.tuple.TupleIsRing
import com.alecdorrington.scalgebra.ordered.builder.OrderedRingBuilder

/** Methods for constructing [[Ring]] type classes. */
trait RingBuilder
  extends OrderedRingBuilder,
          EuclideanRingBuilder,
          TupleIsRing,
          FutureIsRing,
          FunctionIsRing
