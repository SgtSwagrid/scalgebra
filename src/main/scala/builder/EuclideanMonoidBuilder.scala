package com.alecdorrington.scalgebra
package builder

import com.alecdorrington.scalgebra.EuclideanMonoid
import com.alecdorrington.scalgebra.evidence.function.FunctionIsEuclideanMonoid
import com.alecdorrington.scalgebra.evidence.future.FutureIsEuclideanMonoid
import com.alecdorrington.scalgebra.evidence.tuple.TupleIsEuclideanMonoid
import com.alecdorrington.scalgebra.ordered.builder.OrderedEuclideanMonoidBuilder

/** Methods for constructing [[EuclideanMonoid]] type classes. */
trait EuclideanMonoidBuilder
  extends OrderedEuclideanMonoidBuilder,
          MultiplicativeGroupBuilder,
          EuclideanRingBuilder,
          TupleIsEuclideanMonoid,
          FutureIsEuclideanMonoid,
          FunctionIsEuclideanMonoid
