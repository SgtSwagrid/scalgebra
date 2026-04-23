package com.alecdorrington.scalgebra
package ordered

/** An ordered version of [[Difference]]. */
trait OrderedDifference[X] extends Difference[X], Order[X]

/** The companion object for [[OrderedDifference]]. */
object OrderedDifference extends OrderedDifference.Ops:

  trait Ops extends Difference.Ops

  export com.alecdorrington.scalgebra.ordered.OrderedDifference

  /** The [[OrderedDifference]] instance describing the current algebra system. */
  inline def orderedDifference[X : OrderedDifference as orderedDifference]
    : OrderedDifference[X] = orderedDifference
