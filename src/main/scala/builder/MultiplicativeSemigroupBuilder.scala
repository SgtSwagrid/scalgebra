package io.github.sgtswagrid.structures
package builder

import io.github.sgtswagrid.structures.MultiplicativeSemigroup
import io.github.sgtswagrid.structures.evidence.function.FunctionIsMultiplicativeSemigroup
import io.github.sgtswagrid.structures.evidence.future.FutureIsMultiplicativeSemigroup
import io.github.sgtswagrid.structures.evidence.tuple.TupleIsMultiplicativeSemigroup
import io.github.sgtswagrid.structures.ordered.builder.OrderedMultiplicativeSemigroupBuilder

/** Methods for constructing [[MultiplicativeSemigroup]] type classes. */
trait MultiplicativeSemigroupBuilder
  extends OrderedMultiplicativeSemigroupBuilder,
          MultiplicativeMonoidBuilder,
          TupleIsMultiplicativeSemigroup,
          FutureIsMultiplicativeSemigroup,
          FunctionIsMultiplicativeSemigroup
