package com.alecdorrington.scalgebra

import com.alecdorrington.scalgebra.builder.FieldBuilder
import com.alecdorrington.scalgebra.ops.FieldOps

/** For algebraic structures with addition, multiplication, and inverses. */
trait Field[X] extends EuclideanRing[X], DifferenceSemifield[X]:

  override inline def mod(x: X, y: X): X = zero

/**
  * The companion object for [[Field]]. Import as
  * ```scala
  * import com.alecdorrington.scalgebra.Field.{*, given}
  * ```
  * to receive all necessary syntax for working with fields.
  */
object Field extends FieldBuilder, FieldOps:

  export com.alecdorrington.scalgebra.Field

  /** The [[Field]] instance describing the current algebra system. */
  inline def field[X : Field as field]: Field[X] = field
