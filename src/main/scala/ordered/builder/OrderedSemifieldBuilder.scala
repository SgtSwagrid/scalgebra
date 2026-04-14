package io.github.sgtswagrid.structures
package ordered.builder

import io.github.sgtswagrid.structures.evidence.tuple.TupleIsOrderedSemifield
import io.github.sgtswagrid.structures.ordered.OrderedSemifield

/** Methods for constructing [[OrderedSemifield]] type classes. */
trait OrderedSemifieldBuilder
  extends OrderedFieldBuilder, TupleIsOrderedSemifield
