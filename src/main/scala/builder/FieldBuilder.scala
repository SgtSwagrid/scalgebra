package com.alecdorrington.scalgebra
package builder

import com.alecdorrington.scalgebra.Field
import com.alecdorrington.scalgebra.evidence.function.FunctionIsField
import com.alecdorrington.scalgebra.evidence.future.FutureIsField
import com.alecdorrington.scalgebra.evidence.tuple.TupleIsField
import com.alecdorrington.scalgebra.ordered.builder.OrderedFieldBuilder

/** Methods for constructing [[Field]] type classes. */
trait FieldBuilder
  extends OrderedFieldBuilder, TupleIsField, FutureIsField, FunctionIsField
