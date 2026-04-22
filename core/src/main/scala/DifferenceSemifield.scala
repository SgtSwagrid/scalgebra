package com.alecdorrington.scalgebra

import com.alecdorrington.scalgebra.builder.DifferenceSemifieldBuilder
import com.alecdorrington.scalgebra.ops.DifferenceSemifieldOps

/**
  * For algebraic structures with addition, subtraction, multiplication, and
  * reciprocation.
  */
trait DifferenceSemifield[X] extends DifferenceSemiring[X], Semifield[X]

/**
  * The companion object for [[DifferenceSemifield]]. Import as
  * ```scala
  * import com.alecdorrington.scalgebra.DifferenceSemifield.{*, given}
  * ```
  * to receive all necessary syntax for working with difference semifields.
  */
object DifferenceSemifield
  extends DifferenceSemifieldBuilder, DifferenceSemifieldOps:

  export com.alecdorrington.scalgebra.DifferenceSemifield

  /**
    * The [[DifferenceSemifield]] instance describing the current algebra
    * system.
    */
  inline def differenceSemifield[X : DifferenceSemifield as differenceSemifield]
    : DifferenceSemifield[X] = differenceSemifield
