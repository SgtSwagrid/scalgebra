package com.alecdorrington.scalgebra
package ordered

/** An ordered version of [[MultiplicativeInverse]]. */
trait OrderedMultiplicativeInverse[X] extends MultiplicativeInverse[X], Order[X]

/** The companion object for [[OrderedMultiplicativeInverse]]. */
object OrderedMultiplicativeInverse extends OrderedMultiplicativeInverse.Ops:

  trait Ops extends MultiplicativeInverse.Ops

  export com.alecdorrington.scalgebra.ordered.OrderedMultiplicativeInverse

  /**
    * The [[OrderedMultiplicativeInverse]] instance describing the current
    * algebra system.
    */
  inline def orderedMultiplicativeInverse[
    X : OrderedMultiplicativeInverse as orderedMultiplicativeInverse,
  ]: OrderedMultiplicativeInverse[X] = orderedMultiplicativeInverse
