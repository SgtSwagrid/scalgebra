package io.github.sgtswagrid.structures
package builder

import io.github.sgtswagrid.structures.MultiplicativeGroup
import io.github.sgtswagrid.structures.ordered.builder.OrderedMultiplicativeGroupBuilder

/** Methods for constructing [[MultiplicativeGroup]] type classes. */
trait MultiplicativeGroupBuilder
  extends OrderedMultiplicativeGroupBuilder, SemifieldBuilder
