package com.alecdorrington.scalgebra
package builder

import com.alecdorrington.scalgebra.Semiring
import com.alecdorrington.scalgebra.evidence.collection.OptionIsSemiring
import com.alecdorrington.scalgebra.evidence.function.FunctionIsSemiring
import com.alecdorrington.scalgebra.evidence.future.FutureIsSemiring
import com.alecdorrington.scalgebra.evidence.tuple.TupleIsSemiring
import com.alecdorrington.scalgebra.ordered.builder.OrderedSemiringBuilder

/** Methods for constructing [[Semiring]] type classes. */
trait SemiringBuilder
  extends OrderedSemiringBuilder,
          DifferenceSemiringBuilder,
          SemifieldBuilder,
          TupleIsSemiring,
          FutureIsSemiring,
          FunctionIsSemiring,
          OptionIsSemiring
