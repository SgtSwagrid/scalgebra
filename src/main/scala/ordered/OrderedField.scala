package io.github.sgtswagrid.structures
package ordered

import io.github.sgtswagrid.structures.Field
import io.github.sgtswagrid.structures.ordered.builder.OrderedFieldBuilder
import io.github.sgtswagrid.structures.ordered.ops.OrderedFieldOps

/** An ordered version of [[Field]]. */
trait OrderedField[X]
  extends Field[X], OrderedEuclideanRing[X], OrderedSemifield[X]

/**
  * The companion object for [[OrderedField]]. Import as
  * ```scala
  * import io.github.sgtswagrid.structures.ordered.OrderedField.{*, given}
  * ```
  * to receive all necessary syntax for working with ordered fields.
  */
object OrderedField extends OrderedFieldBuilder, OrderedFieldOps:

  export io.github.sgtswagrid.structures.ordered.OrderedField

  /** The [[OrderedField]] instance describing the current algebra system. */
  inline def orderedField[X : OrderedField as orderedField]: OrderedField[X] =
    orderedField
