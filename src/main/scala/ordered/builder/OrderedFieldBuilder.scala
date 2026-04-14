package io.github.sgtswagrid.structures
package ordered.builder

import io.github.sgtswagrid.structures.evidence.numeric.{
  DoubleIsOrderedEuclideanRing, FloatIsOrderedField, FractionalIsOrderedField,
}
import io.github.sgtswagrid.structures.evidence.trivial.{
  EmptyTupleIsOrderedField, NoneIsOrderedField, NothingIsOrderedField,
  SingletonIsOrderedField, UnitIsOrderedField,
}
import io.github.sgtswagrid.structures.evidence.tuple.TupleIsOrderedField
import io.github.sgtswagrid.structures.ordered.OrderedField

/** Methods for constructing [[OrderedField]] type classes. */
trait OrderedFieldBuilder
  extends DoubleIsOrderedEuclideanRing,
          EmptyTupleIsOrderedField,
          FloatIsOrderedField,
          NoneIsOrderedField,
          NothingIsOrderedField,
          UnitIsOrderedField,
          SingletonIsOrderedField,
          FractionalIsOrderedField,
          TupleIsOrderedField
