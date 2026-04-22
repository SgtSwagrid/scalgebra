package com.alecdorrington.scalgebra
package builder

import com.alecdorrington.scalgebra.DifferenceSemifield
import com.alecdorrington.scalgebra.evidence.function.FunctionIsDifferenceSemifield
import com.alecdorrington.scalgebra.evidence.future.FutureIsDifferenceSemifield
import com.alecdorrington.scalgebra.evidence.tuple.TupleIsDifferenceSemifield
import com.alecdorrington.scalgebra.ordered.builder.OrderedDifferenceSemifieldBuilder

/** Methods for constructing [[DifferenceSemifield]] type classes. */
trait DifferenceSemifieldBuilder
  extends OrderedDifferenceSemifieldBuilder,
          FieldBuilder,
          TupleIsDifferenceSemifield,
          FutureIsDifferenceSemifield,
          FunctionIsDifferenceSemifield
