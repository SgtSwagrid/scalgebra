package io.github.sgtswagrid.structures
package builder

import io.github.sgtswagrid.structures.DifferenceMonoid
import io.github.sgtswagrid.structures.evidence.function.FunctionIsDifferenceMonoid
import io.github.sgtswagrid.structures.evidence.future.FutureIsDifferenceMonoid
import io.github.sgtswagrid.structures.evidence.tuple.TupleIsDifferenceMonoid
import io.github.sgtswagrid.structures.ordered.builder.OrderedDifferenceMonoidBuilder

/** Methods for constructing [[DifferenceMonoid]] type classes. */
trait DifferenceMonoidBuilder
  extends OrderedDifferenceMonoidBuilder,
          AdditiveGroupBuilder,
          DifferenceSemiringBuilder,
          TupleIsDifferenceMonoid,
          FutureIsDifferenceMonoid,
          FunctionIsDifferenceMonoid
