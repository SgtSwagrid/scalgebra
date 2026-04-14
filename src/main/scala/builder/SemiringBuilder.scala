package io.github.sgtswagrid.structures
package builder

import io.github.sgtswagrid.structures.Semiring
import io.github.sgtswagrid.structures.evidence.collection.OptionIsSemiring
import io.github.sgtswagrid.structures.evidence.function.FunctionIsSemiring
import io.github.sgtswagrid.structures.evidence.future.FutureIsSemiring
import io.github.sgtswagrid.structures.evidence.tuple.TupleIsSemiring
import io.github.sgtswagrid.structures.ordered.builder.OrderedSemiringBuilder

/** Methods for constructing [[Semiring]] type classes. */
trait SemiringBuilder
  extends OrderedSemiringBuilder,
          DifferenceSemiringBuilder,
          SemifieldBuilder,
          TupleIsSemiring,
          FutureIsSemiring,
          FunctionIsSemiring,
          OptionIsSemiring
