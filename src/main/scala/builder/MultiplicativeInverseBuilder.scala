package com.alecdorrington.scalgebra
package builder

import com.alecdorrington.scalgebra.MultiplicativeInverse
import com.alecdorrington.scalgebra.evidence.function.FunctionIsMultiplicativeInverse
import com.alecdorrington.scalgebra.evidence.future.FutureIsMultiplicativeInverse
import com.alecdorrington.scalgebra.evidence.tuple.TupleIsMultiplicativeInverse
import com.alecdorrington.scalgebra.ordered.builder.OrderedMultiplicativeInverseBuilder

/** Methods for constructing [[MultiplicativeInverse]] type classes. */
trait MultiplicativeInverseBuilder
  extends OrderedMultiplicativeInverseBuilder,
          MultiplicativeGroupBuilder,
          TupleIsMultiplicativeInverse,
          FutureIsMultiplicativeInverse,
          FunctionIsMultiplicativeInverse
