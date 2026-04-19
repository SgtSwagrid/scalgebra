package com.alecdorrington.scalgebra
package builder

import com.alecdorrington.scalgebra.DifferenceMonoid
import com.alecdorrington.scalgebra.evidence.function.FunctionIsDifferenceMonoid
import com.alecdorrington.scalgebra.evidence.future.FutureIsDifferenceMonoid
import com.alecdorrington.scalgebra.evidence.tuple.TupleIsDifferenceMonoid
import com.alecdorrington.scalgebra.ordered.builder.OrderedDifferenceMonoidBuilder

/** Methods for constructing [[DifferenceMonoid]] type classes. */
trait DifferenceMonoidBuilder
  extends OrderedDifferenceMonoidBuilder,
          AdditiveGroupBuilder,
          DifferenceSemiringBuilder,
          TupleIsDifferenceMonoid,
          FutureIsDifferenceMonoid,
          FunctionIsDifferenceMonoid
