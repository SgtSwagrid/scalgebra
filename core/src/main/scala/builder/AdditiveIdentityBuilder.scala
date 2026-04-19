package com.alecdorrington.scalgebra
package builder

import com.alecdorrington.scalgebra.AdditiveIdentity
import com.alecdorrington.scalgebra.evidence.function.FunctionIsAdditiveIdentity
import com.alecdorrington.scalgebra.evidence.future.FutureIsAdditiveIdentity
import com.alecdorrington.scalgebra.evidence.tuple.TupleIsAdditiveIdentity
import com.alecdorrington.scalgebra.ordered.builder.OrderedAdditiveIdentityBuilder

/** Methods for constructing [[AdditiveIdentity]] type classes. */
trait AdditiveIdentityBuilder
  extends OrderedAdditiveIdentityBuilder,
          AdditiveMonoidBuilder,
          TupleIsAdditiveIdentity,
          FutureIsAdditiveIdentity,
          FunctionIsAdditiveIdentity
