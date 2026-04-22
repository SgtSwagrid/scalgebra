package com.alecdorrington.scalgebra
package ordered

import com.alecdorrington.scalgebra.DifferenceSemifield
import com.alecdorrington.scalgebra.ordered.builder.OrderedDifferenceSemifieldBuilder
import com.alecdorrington.scalgebra.ordered.ops.OrderedDifferenceSemifieldOps

/** An ordered version of [[DifferenceSemifield]]. */
trait OrderedDifferenceSemifield[X]
  extends DifferenceSemifield[X],
          OrderedDifferenceSemiring[X],
          OrderedSemifield[X]

/**
  * The companion object for [[OrderedDifferenceSemifield]]. Import as
  * ```scala
  * import com.alecdorrington.scalgebra.ordered.OrderedDifferenceSemifield.{
  *   *, given,
  * }
  * ```
  * to receive all necessary syntax for working with ordered difference
  * semifields.
  */
object OrderedDifferenceSemifield
  extends OrderedDifferenceSemifieldBuilder, OrderedDifferenceSemifieldOps:

  export com.alecdorrington.scalgebra.ordered.OrderedDifferenceSemifield

  /**
    * The [[OrderedDifferenceSemifield]] instance describing the current algebra
    * system.
    */
  inline def orderedDifferenceSemifield[
    X : OrderedDifferenceSemifield as orderedDifferenceSemifield,
  ]: OrderedDifferenceSemifield[X] = orderedDifferenceSemifield
