package io.github.sgtswagrid.structures
package ordered.builder

import io.github.sgtswagrid.structures.evidence.tuple.TupleIsOrderedAdditiveInverse
import io.github.sgtswagrid.structures.ordered.OrderedAdditiveInverse

/** Methods for constructing [[OrderedAdditiveInverse]] type classes. */
trait OrderedAdditiveInverseBuilder
  extends OrderedAdditiveGroupBuilder, TupleIsOrderedAdditiveInverse
