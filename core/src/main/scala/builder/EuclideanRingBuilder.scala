package com.alecdorrington.scalgebra
package builder

import com.alecdorrington.scalgebra.EuclideanRing
import com.alecdorrington.scalgebra.evidence.function.FunctionIsEuclideanRing
import com.alecdorrington.scalgebra.evidence.future.FutureIsEuclideanRing
import com.alecdorrington.scalgebra.evidence.tuple.TupleIsEuclideanRing
import com.alecdorrington.scalgebra.ordered.builder.OrderedEuclideanRingBuilder

/** Methods for constructing [[EuclideanRing]] type classes. */
trait EuclideanRingBuilder
  extends OrderedEuclideanRingBuilder,
          FieldBuilder,
          TupleIsEuclideanRing,
          FutureIsEuclideanRing,
          FunctionIsEuclideanRing
