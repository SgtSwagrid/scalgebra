package com.alecdorrington.scalgebra
package ordered

/** An ordered version of [[Field]]. */
trait OrderedField[X]
  extends Field[X], OrderedEuclideanRing[X], OrderedDifferenceSemifield[X]

/** The companion object for [[OrderedField]]. */
object OrderedField extends OrderedField.Ops:

  trait Ops
    extends Field.Ops, OrderedEuclideanRing.Ops, OrderedDifferenceSemifield.Ops

  export com.alecdorrington.scalgebra.ordered.OrderedField

  /** The [[OrderedField]] instance describing the current algebra system. */
  inline def orderedField[X : OrderedField as orderedField]: OrderedField[X] =
    orderedField
