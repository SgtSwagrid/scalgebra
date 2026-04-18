package com.alecdorrington.scalgebra
package builder

import com.alecdorrington.scalgebra.MultiplicativeIdentity
import com.alecdorrington.scalgebra.evidence.function.FunctionIsMultiplicativeIdentity
import com.alecdorrington.scalgebra.evidence.future.FutureIsMultiplicativeIdentity
import com.alecdorrington.scalgebra.evidence.tuple.TupleIsMultiplicativeIdentity
import com.alecdorrington.scalgebra.ordered.builder.OrderedMultiplicativeIdentityBuilder

/** Methods for constructing [[MultiplicativeIdentity]] type classes. */
trait MultiplicativeIdentityBuilder
  extends OrderedMultiplicativeIdentityBuilder,
          MultiplicativeMonoidBuilder,
          TupleIsMultiplicativeIdentity,
          FutureIsMultiplicativeIdentity,
          FunctionIsMultiplicativeIdentity
