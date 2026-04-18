package com.alecdorrington.scalgebra
package builder

import com.alecdorrington.scalgebra.MultiplicativeGroup
import com.alecdorrington.scalgebra.evidence.function.FunctionIsMultiplicativeGroup
import com.alecdorrington.scalgebra.evidence.future.FutureIsMultiplicativeGroup
import com.alecdorrington.scalgebra.evidence.tuple.TupleIsMultiplicativeGroup
import com.alecdorrington.scalgebra.ordered.builder.OrderedMultiplicativeGroupBuilder

/** Methods for constructing [[MultiplicativeGroup]] type classes. */
trait MultiplicativeGroupBuilder
  extends OrderedMultiplicativeGroupBuilder,
          SemifieldBuilder,
          TupleIsMultiplicativeGroup,
          FutureIsMultiplicativeGroup,
          FunctionIsMultiplicativeGroup
