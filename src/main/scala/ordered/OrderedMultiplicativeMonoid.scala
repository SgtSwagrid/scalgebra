package com.alecdorrington.scalgebra
package ordered

import com.alecdorrington.scalgebra.MultiplicativeMonoid
import com.alecdorrington.scalgebra.ordered.builder.OrderedMultiplicativeMonoidBuilder
import com.alecdorrington.scalgebra.ordered.ops.OrderedMultiplicativeMonoidOps

/** An ordered version of [[MultiplicativeMonoid]]. */
trait OrderedMultiplicativeMonoid[X]
  extends MultiplicativeMonoid[X],
          OrderedMultiplicativeSemigroup[X],
          OrderedMultiplicativeIdentity[X]

/**
  * The companion object for [[OrderedMultiplicativeMonoid]]. Import as
  * ```scala
  * import com.alecdorrington.scalgebra.ordered.OrderedMultiplicativeMonoid.{
  *   *, given,
  * }
  * ```
  * to receive all necessary syntax for working with ordered multiplicative
  * monoids.
  */
object OrderedMultiplicativeMonoid
  extends OrderedMultiplicativeMonoidBuilder, OrderedMultiplicativeMonoidOps:

  export com.alecdorrington.scalgebra.ordered.OrderedMultiplicativeMonoid

  /**
    * The [[OrderedMultiplicativeMonoid]] instance describing the current
    * algebra system.
    */
  inline def orderedMultiplicativeMonoid[
    X : OrderedMultiplicativeMonoid as orderedMultiplicativeMonoid,
  ]: OrderedMultiplicativeMonoid[X] = orderedMultiplicativeMonoid
