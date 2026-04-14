package io.github.sgtswagrid.structures

import io.github.sgtswagrid.structures.builder.FieldBuilder
import io.github.sgtswagrid.structures.ops.FieldOps

/** For algebraic structures with addition, multiplication, and inverses. */
trait Field[X] extends EuclideanRing[X], Semifield[X]:

  override inline def mod(x: X, y: X): X = zero

/**
  * The companion object for [[Field]]. Import as
  * ```scala
  * import io.github.sgtswagrid.structures.Field.{*, given}
  * ```
  * to receive all necessary syntax for working with fields.
  */
object Field extends FieldBuilder, FieldOps:

  export io.github.sgtswagrid.structures.Field

  /** The [[Field]] instance describing the current algebra system. */
  inline def field[X : Field as field]: Field[X] = field
