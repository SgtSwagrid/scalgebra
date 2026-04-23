package com.alecdorrington.scalgebra
package ordered

/** An ordered version of [[AdditiveInverse]]. */
trait OrderedAdditiveInverse[X] extends AdditiveInverse[X], Order[X]

/** The companion object for [[OrderedAdditiveInverse]]. */
object OrderedAdditiveInverse extends OrderedAdditiveInverse.Ops:

  trait Ops extends AdditiveInverse.Ops

  export com.alecdorrington.scalgebra.ordered.OrderedAdditiveInverse

  /**
    * The [[OrderedAdditiveInverse]] instance describing the current algebra
    * system.
    */
  inline def orderedAdditiveInverse[
    X : OrderedAdditiveInverse as orderedAdditiveInverse,
  ]: OrderedAdditiveInverse[X] = orderedAdditiveInverse
