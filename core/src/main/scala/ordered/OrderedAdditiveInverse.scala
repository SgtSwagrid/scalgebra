package com.alecdorrington.scalgebra
package ordered

import com.alecdorrington.scalgebra.AdditiveInverse
import com.alecdorrington.scalgebra.ordered.builder.OrderedAdditiveInverseBuilder
import com.alecdorrington.scalgebra.ordered.ops.OrderedAdditiveInverseOps

/** An ordered version of [[AdditiveInverse]]. */
trait OrderedAdditiveInverse[X] extends AdditiveInverse[X], Ordering[X]

/**
  * The companion object for [[OrderedAdditiveInverse]]. Import as
  * ```scala
  * import com.alecdorrington.scalgebra.ordered.OrderedAdditiveInverse.{
  *   *, given,
  * }
  * ```
  * to receive all necessary syntax for working with ordered additive inverses.
  */
object OrderedAdditiveInverse
  extends OrderedAdditiveInverseBuilder, OrderedAdditiveInverseOps:

  export com.alecdorrington.scalgebra.ordered.OrderedAdditiveInverse

  /**
    * The [[OrderedAdditiveInverse]] instance describing the current algebra
    * system.
    */
  inline def orderedAdditiveInverse[
    X : OrderedAdditiveInverse as orderedAdditiveInverse,
  ]: OrderedAdditiveInverse[X] = orderedAdditiveInverse
