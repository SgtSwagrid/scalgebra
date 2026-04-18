package com.alecdorrington.scalgebra
package ordered

import com.alecdorrington.scalgebra.Field
import com.alecdorrington.scalgebra.ordered.builder.OrderedFieldBuilder
import com.alecdorrington.scalgebra.ordered.ops.OrderedFieldOps

/** An ordered version of [[Field]]. */
trait OrderedField[X]
  extends Field[X], OrderedEuclideanRing[X], OrderedSemifield[X]

/**
  * The companion object for [[OrderedField]]. Import as
  * ```scala
  * import com.alecdorrington.scalgebra.ordered.OrderedField.{*, given}
  * ```
  * to receive all necessary syntax for working with ordered fields.
  */
object OrderedField extends OrderedFieldBuilder, OrderedFieldOps:

  export com.alecdorrington.scalgebra.ordered.OrderedField

  /** The [[OrderedField]] instance describing the current algebra system. */
  inline def orderedField[X : OrderedField as orderedField]: OrderedField[X] =
    orderedField
