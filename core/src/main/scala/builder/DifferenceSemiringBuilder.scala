package com.alecdorrington.scalgebra
package builder

import com.alecdorrington.scalgebra.DifferenceSemiring
import com.alecdorrington.scalgebra.evidence.function.FunctionIsDifferenceSemiring
import com.alecdorrington.scalgebra.evidence.future.FutureIsDifferenceSemiring
import com.alecdorrington.scalgebra.evidence.tuple.TupleIsDifferenceSemiring
import com.alecdorrington.scalgebra.ordered.builder.OrderedDifferenceSemiringBuilder

/** Methods for constructing [[DifferenceSemiring]] type classes. */
trait DifferenceSemiringBuilder
  extends OrderedDifferenceSemiringBuilder,
          DifferenceSemifieldBuilder,
          RingBuilder,
          TupleIsDifferenceSemiring,
          FutureIsDifferenceSemiring,
          FunctionIsDifferenceSemiring
