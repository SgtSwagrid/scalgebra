package io.github.sgtswagrid.structures
package builder

import io.github.sgtswagrid.structures.DifferenceSemiring
import io.github.sgtswagrid.structures.evidence.function.FunctionIsDifferenceSemiring
import io.github.sgtswagrid.structures.evidence.future.FutureIsDifferenceSemiring
import io.github.sgtswagrid.structures.evidence.tuple.TupleIsDifferenceSemiring
import io.github.sgtswagrid.structures.ordered.builder.OrderedDifferenceSemiringBuilder

/** Methods for constructing [[DifferenceSemiring]] type classes. */
trait DifferenceSemiringBuilder
  extends OrderedDifferenceSemiringBuilder,
          RingBuilder,
          TupleIsDifferenceSemiring,
          FutureIsDifferenceSemiring,
          FunctionIsDifferenceSemiring
