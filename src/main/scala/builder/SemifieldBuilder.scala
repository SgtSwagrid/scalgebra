package com.alecdorrington.scalgebra
package builder

import com.alecdorrington.scalgebra.Semifield
import com.alecdorrington.scalgebra.evidence.function.FunctionIsSemifield
import com.alecdorrington.scalgebra.evidence.future.FutureIsSemifield
import com.alecdorrington.scalgebra.evidence.tuple.TupleIsSemifield
import com.alecdorrington.scalgebra.ordered.builder.OrderedSemifieldBuilder

/** Methods for constructing [[Semifield]] type classes. */
trait SemifieldBuilder
  extends OrderedSemifieldBuilder,
          FieldBuilder,
          TupleIsSemifield,
          FutureIsSemifield,
          FunctionIsSemifield
