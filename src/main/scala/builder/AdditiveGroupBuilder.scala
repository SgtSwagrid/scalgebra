package com.alecdorrington.scalgebra
package builder

import com.alecdorrington.scalgebra.AdditiveGroup
import com.alecdorrington.scalgebra.evidence.function.FunctionIsAdditiveGroup
import com.alecdorrington.scalgebra.evidence.future.FutureIsAdditiveGroup
import com.alecdorrington.scalgebra.evidence.tuple.TupleIsAdditiveGroup
import com.alecdorrington.scalgebra.ordered.builder.OrderedAdditiveGroupBuilder

/** Methods for constructing [[AdditiveGroup]] type classes. */
trait AdditiveGroupBuilder
  extends OrderedAdditiveGroupBuilder,
          RingBuilder,
          TupleIsAdditiveGroup,
          FutureIsAdditiveGroup,
          FunctionIsAdditiveGroup
