package com.alecdorrington.scalgebra

import com.alecdorrington.scalgebra.builder.DifferenceSemiringBuilder
import com.alecdorrington.scalgebra.ops.DifferenceSemiringOps

/** For algebraic structures with addition, subtraction, and multiplication. */
trait DifferenceSemiring[X] extends Semiring[X], DifferenceMonoid[X]

/**
  * The companion object for [[DifferenceSemiring]]. Import as
  * ```scala
  * import com.alecdorrington.scalgebra.DifferenceSemiring.{*, given}
  * ```
  * to receive all necessary syntax for working with difference semirings.
  */
object DifferenceSemiring
  extends DifferenceSemiringBuilder, DifferenceSemiringOps:

  export com.alecdorrington.scalgebra.DifferenceSemiring

  /** The [[DifferenceSemiring]] instance describing the current algebra system. */
  inline def differenceSemiring[X : DifferenceSemiring as differenceSemiring]
    : DifferenceSemiring[X] = differenceSemiring
