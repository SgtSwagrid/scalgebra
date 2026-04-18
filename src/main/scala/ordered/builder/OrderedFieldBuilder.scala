package com.alecdorrington.scalgebra
package ordered.builder

import com.alecdorrington.scalgebra.evidence.numeric.{
  DoubleIsOrderedEuclideanRing, FloatIsOrderedField, FractionalIsOrderedField,
}
import com.alecdorrington.scalgebra.evidence.trivial.{
  EmptyTupleIsOrderedField, NoneIsOrderedField, NothingIsOrderedField,
  SingletonIsOrderedField, UnitIsOrderedField,
}
import com.alecdorrington.scalgebra.evidence.tuple.TupleIsOrderedField
import com.alecdorrington.scalgebra.ordered.OrderedField

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
