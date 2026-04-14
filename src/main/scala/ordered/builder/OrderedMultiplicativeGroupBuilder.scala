package io.github.sgtswagrid.structures
package ordered.builder

import io.github.sgtswagrid.structures.evidence.tuple.TupleIsOrderedMultiplicativeGroup
import io.github.sgtswagrid.structures.ordered.OrderedMultiplicativeGroup

/** Methods for constructing [[OrderedMultiplicativeGroup]] type classes. */
trait OrderedMultiplicativeGroupBuilder
  extends OrderedSemifieldBuilder, TupleIsOrderedMultiplicativeGroup
