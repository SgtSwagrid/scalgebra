package io.github.sgtswagrid.structures
package builder

import io.github.sgtswagrid.structures.Field
import io.github.sgtswagrid.structures.evidence.function.FunctionIsField
import io.github.sgtswagrid.structures.evidence.future.FutureIsField
import io.github.sgtswagrid.structures.evidence.tuple.TupleIsField
import io.github.sgtswagrid.structures.ordered.builder.OrderedFieldBuilder

/** Methods for constructing [[Field]] type classes. */
trait FieldBuilder
  extends OrderedFieldBuilder, TupleIsField, FutureIsField, FunctionIsField
