package com.alecdorrington.scalgebra
package builder

import com.alecdorrington.scalgebra.AdditiveSemigroup
import com.alecdorrington.scalgebra.evidence.function.FunctionIsAdditiveSemigroup
import com.alecdorrington.scalgebra.evidence.future.FutureIsAdditiveSemigroup
import com.alecdorrington.scalgebra.evidence.tuple.TupleIsAdditiveSemigroup
import com.alecdorrington.scalgebra.ordered.builder.OrderedAdditiveSemigroupBuilder

/** Methods for constructing [[AdditiveSemigroup]] type classes. */
trait AdditiveSemigroupBuilder
  extends OrderedAdditiveSemigroupBuilder,
          AdditiveMonoidBuilder,
          TupleIsAdditiveSemigroup,
          FutureIsAdditiveSemigroup,
          FunctionIsAdditiveSemigroup
