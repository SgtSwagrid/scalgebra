package com.alecdorrington.scalgebra
package builder

import com.alecdorrington.scalgebra.MultiplicativeSemigroup
import com.alecdorrington.scalgebra.evidence.function.FunctionIsMultiplicativeSemigroup
import com.alecdorrington.scalgebra.evidence.future.FutureIsMultiplicativeSemigroup
import com.alecdorrington.scalgebra.evidence.tuple.TupleIsMultiplicativeSemigroup
import com.alecdorrington.scalgebra.ordered.builder.OrderedMultiplicativeSemigroupBuilder

/** Methods for constructing [[MultiplicativeSemigroup]] type classes. */
trait MultiplicativeSemigroupBuilder
  extends OrderedMultiplicativeSemigroupBuilder,
          MultiplicativeMonoidBuilder,
          TupleIsMultiplicativeSemigroup,
          FutureIsMultiplicativeSemigroup,
          FunctionIsMultiplicativeSemigroup
