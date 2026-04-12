package io.github.sgtswagrid.structures
package ordered.builder

import io.github.sgtswagrid.structures.evidence.{
  DoubleIsOrderedEuclideanRing, FloatIsOrderedField, NothingIsOrderedField,
}
import io.github.sgtswagrid.structures.ordered.OrderedField

/** Methods for constructing [[OrderedField]] type classes. */
trait OrderedFieldBuilder
  extends DoubleIsOrderedEuclideanRing,
          FloatIsOrderedField,
          NothingIsOrderedField
