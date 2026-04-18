package com.alecdorrington.scalgebra
package ordered

import com.alecdorrington.scalgebra.MultiplicativeInverse
import com.alecdorrington.scalgebra.ordered.builder.OrderedMultiplicativeInverseBuilder
import com.alecdorrington.scalgebra.ordered.ops.OrderedMultiplicativeInverseOps

/** An ordered version of [[MultiplicativeInverse]]. */
trait OrderedMultiplicativeInverse[X]
  extends MultiplicativeInverse[X], Ordering[X]

/**
  * The companion object for [[OrderedMultiplicativeInverse]]. Import as
  * ```scala
  * import com.alecdorrington.scalgebra.ordered.OrderedMultiplicativeInverse.{
  *   *, given,
  * }
  * ```
  * to receive all necessary syntax for working with ordered multiplicative
  * inverses.
  */
object OrderedMultiplicativeInverse
  extends OrderedMultiplicativeInverseBuilder, OrderedMultiplicativeInverseOps:

  export com.alecdorrington.scalgebra.ordered.OrderedMultiplicativeInverse

  /**
    * The [[OrderedMultiplicativeInverse]] instance describing the current
    * algebra system.
    */
  inline def orderedMultiplicativeInverse[
    X : OrderedMultiplicativeInverse as orderedMultiplicativeInverse,
  ]: OrderedMultiplicativeInverse[X] = orderedMultiplicativeInverse
