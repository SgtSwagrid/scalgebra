package io.github.sgtswagrid.structures
package ordered.builder

import io.github.sgtswagrid.structures.evidence.tuple.TupleIsOrderedMultiplicativeInverse
import io.github.sgtswagrid.structures.ordered.OrderedMultiplicativeInverse

/** Methods for constructing [[OrderedMultiplicativeInverse]] type classes. */
trait OrderedMultiplicativeInverseBuilder
  extends OrderedMultiplicativeGroupBuilder, TupleIsOrderedMultiplicativeInverse
