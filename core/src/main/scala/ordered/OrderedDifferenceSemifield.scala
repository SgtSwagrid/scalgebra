package com.alecdorrington.scalgebra
package ordered

/** An ordered version of [[DifferenceSemifield]]. */
trait OrderedDifferenceSemifield[X]
  extends DifferenceSemifield[X],
          OrderedDifferenceSemiring[X],
          OrderedSemifield[X]

/** The companion object for [[OrderedDifferenceSemifield]]. */
object OrderedDifferenceSemifield extends OrderedDifferenceSemifield.Ops:

  trait Ops
    extends DifferenceSemifield.Ops,
            OrderedDifferenceSemiring.Ops,
            OrderedSemifield.Ops

  export com.alecdorrington.scalgebra.ordered.OrderedDifferenceSemifield

  /**
    * The [[OrderedDifferenceSemifield]] instance describing the current algebra
    * system.
    */
  inline def orderedDifferenceSemifield[
    X : OrderedDifferenceSemifield as orderedDifferenceSemifield,
  ]: OrderedDifferenceSemifield[X] = orderedDifferenceSemifield
