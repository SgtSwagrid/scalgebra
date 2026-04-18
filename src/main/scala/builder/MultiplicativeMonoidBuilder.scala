package com.alecdorrington.scalgebra
package builder

import com.alecdorrington.scalgebra.MultiplicativeMonoid
import com.alecdorrington.scalgebra.evidence.function.FunctionIsMultiplicativeMonoid
import com.alecdorrington.scalgebra.evidence.future.FutureIsMultiplicativeMonoid
import com.alecdorrington.scalgebra.evidence.tuple.TupleIsMultiplicativeMonoid
import com.alecdorrington.scalgebra.ordered.builder.OrderedMultiplicativeMonoidBuilder

/** Methods for constructing [[MultiplicativeMonoid]] type classes. */
trait MultiplicativeMonoidBuilder
  extends OrderedMultiplicativeMonoidBuilder,
          EuclideanMonoidBuilder,
          SemiringBuilder,
          TupleIsMultiplicativeMonoid,
          FutureIsMultiplicativeMonoid,
          FunctionIsMultiplicativeMonoid
