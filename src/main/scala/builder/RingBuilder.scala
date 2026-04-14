package io.github.sgtswagrid.structures
package builder

import io.github.sgtswagrid.structures.Ring
import io.github.sgtswagrid.structures.evidence.function.FunctionIsRing
import io.github.sgtswagrid.structures.evidence.future.FutureIsRing
import io.github.sgtswagrid.structures.evidence.tuple.TupleIsRing
import io.github.sgtswagrid.structures.ordered.builder.OrderedRingBuilder

/** Methods for constructing [[Ring]] type classes. */
trait RingBuilder
  extends OrderedRingBuilder,
          EuclideanRingBuilder,
          TupleIsRing,
          FutureIsRing,
          FunctionIsRing
