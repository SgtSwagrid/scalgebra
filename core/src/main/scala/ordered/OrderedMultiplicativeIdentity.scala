package com.alecdorrington.scalgebra
package ordered

/** An ordered version of [[MultiplicativeIdentity]]. */
trait OrderedMultiplicativeIdentity[X]
  extends MultiplicativeIdentity[X], Order[X]

/** The companion object for [[OrderedMultiplicativeIdentity]]. */
object OrderedMultiplicativeIdentity extends OrderedMultiplicativeIdentity.Ops:

  trait Ops extends MultiplicativeIdentity.Ops

  export com.alecdorrington.scalgebra.ordered.OrderedMultiplicativeIdentity

  /**
    * The [[OrderedMultiplicativeIdentity]] instance describing the current
    * algebra system.
    */
  inline def orderedMultiplicativeIdentity[
    X : OrderedMultiplicativeIdentity as orderedMultiplicativeIdentity,
  ]: OrderedMultiplicativeIdentity[X] = orderedMultiplicativeIdentity
