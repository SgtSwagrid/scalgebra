package com.alecdorrington.scalgebra
package ordered

import com.alecdorrington.scalgebra.MultiplicativeSemigroup
import com.alecdorrington.scalgebra.ordered.builder.OrderedMultiplicativeSemigroupBuilder
import com.alecdorrington.scalgebra.ordered.ops.OrderedMultiplicativeSemigroupOps

/** An ordered version of [[MultiplicativeSemigroup]]. */
trait OrderedMultiplicativeSemigroup[X]
  extends MultiplicativeSemigroup[X], Ordering[X]

/**
  * The companion object for [[OrderedMultiplicativeSemigroup]]. Import as
  * ```scala
  * import com.alecdorrington.scalgebra.ordered.OrderedMultiplicativeSemigroup.{
  *   *, given,
  * }
  * ```
  * to receive all necessary syntax for working with ordered multiplicative
  * semigroups.
  */
object OrderedMultiplicativeSemigroup
  extends OrderedMultiplicativeSemigroupBuilder,
          OrderedMultiplicativeSemigroupOps:

  export com.alecdorrington.scalgebra.ordered.OrderedMultiplicativeSemigroup

  /**
    * The [[OrderedMultiplicativeSemigroup]] instance describing the current
    * algebra system.
    */
  inline def orderedMultiplicativeSemigroup[
    X : OrderedMultiplicativeSemigroup as orderedMultiplicativeSemigroup,
  ]: OrderedMultiplicativeSemigroup[X] = orderedMultiplicativeSemigroup
