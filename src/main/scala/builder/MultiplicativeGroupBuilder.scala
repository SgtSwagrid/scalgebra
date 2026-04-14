package io.github.sgtswagrid.structures
package builder

import io.github.sgtswagrid.structures.MultiplicativeGroup
import io.github.sgtswagrid.structures.evidence.function.FunctionIsMultiplicativeGroup
import io.github.sgtswagrid.structures.evidence.future.FutureIsMultiplicativeGroup
import io.github.sgtswagrid.structures.evidence.tuple.TupleIsMultiplicativeGroup
import io.github.sgtswagrid.structures.ordered.builder.OrderedMultiplicativeGroupBuilder

/** Methods for constructing [[MultiplicativeGroup]] type classes. */
trait MultiplicativeGroupBuilder
  extends OrderedMultiplicativeGroupBuilder,
          SemifieldBuilder,
          TupleIsMultiplicativeGroup,
          FutureIsMultiplicativeGroup,
          FunctionIsMultiplicativeGroup
