package io.github.sgtswagrid.structures
package ordered.builder

import io.github.sgtswagrid.structures.evidence.tuple.TupleIsOrderedAdditiveGroup
import io.github.sgtswagrid.structures.ordered.OrderedAdditiveGroup

/** Methods for constructing [[OrderedAdditiveGroup]] type classes. */
trait OrderedAdditiveGroupBuilder
  extends OrderedRingBuilder, TupleIsOrderedAdditiveGroup
