package com.alecdorrington.scalgebra
package builder

import com.alecdorrington.scalgebra.AdditiveInverse
import com.alecdorrington.scalgebra.evidence.function.FunctionIsAdditiveInverse
import com.alecdorrington.scalgebra.evidence.future.FutureIsAdditiveInverse
import com.alecdorrington.scalgebra.evidence.tuple.TupleIsAdditiveInverse
import com.alecdorrington.scalgebra.ordered.builder.OrderedAdditiveInverseBuilder

/** Methods for constructing [[AdditiveInverse]] type classes. */
trait AdditiveInverseBuilder
  extends OrderedAdditiveInverseBuilder,
          AdditiveGroupBuilder,
          TupleIsAdditiveInverse,
          FutureIsAdditiveInverse,
          FunctionIsAdditiveInverse
