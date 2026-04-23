package com.alecdorrington.scalgebra
package ordered

/** An ordered version of [[MultiplicativeGroup]]. */
trait OrderedMultiplicativeGroup[X]
  extends MultiplicativeGroup[X],
          OrderedEuclideanMonoid[X],
          OrderedMultiplicativeInverse[X]

/** The companion object for [[OrderedMultiplicativeGroup]]. */
object OrderedMultiplicativeGroup extends OrderedMultiplicativeGroup.Ops:

  trait Ops
    extends MultiplicativeGroup.Ops,
            OrderedEuclideanMonoid.Ops,
            OrderedMultiplicativeInverse.Ops

  export com.alecdorrington.scalgebra.ordered.OrderedMultiplicativeGroup

  /**
    * The [[OrderedMultiplicativeGroup]] instance describing the current algebra
    * system.
    */
  inline def orderedMultiplicativeGroup[
    X : OrderedMultiplicativeGroup as orderedMultiplicativeGroup,
  ]: OrderedMultiplicativeGroup[X] = orderedMultiplicativeGroup
