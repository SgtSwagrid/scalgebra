package io.github.sgtswagrid.structures
package builder

import io.github.sgtswagrid.structures.EuclideanMonoid
import io.github.sgtswagrid.structures.evidence.function.FunctionIsEuclideanMonoid
import io.github.sgtswagrid.structures.evidence.future.FutureIsEuclideanMonoid
import io.github.sgtswagrid.structures.evidence.tuple.TupleIsEuclideanMonoid
import io.github.sgtswagrid.structures.ordered.builder.OrderedEuclideanMonoidBuilder

/** Methods for constructing [[EuclideanMonoid]] type classes. */
trait EuclideanMonoidBuilder
  extends OrderedEuclideanMonoidBuilder,
          MultiplicativeGroupBuilder,
          EuclideanRingBuilder,
          TupleIsEuclideanMonoid,
          FutureIsEuclideanMonoid,
          FunctionIsEuclideanMonoid
