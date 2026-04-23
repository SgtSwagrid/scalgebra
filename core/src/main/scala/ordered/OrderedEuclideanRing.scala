package com.alecdorrington.scalgebra
package ordered

/** An ordered version of [[EuclideanRing]]. */
trait OrderedEuclideanRing[X]
  extends EuclideanRing[X], OrderedRing[X], OrderedEuclideanMonoid[X]

/** The companion object for [[OrderedEuclideanRing]]. */
object OrderedEuclideanRing extends OrderedEuclideanRing.Ops:

  trait Ops
    extends EuclideanRing.Ops, OrderedRing.Ops, OrderedEuclideanMonoid.Ops

  export com.alecdorrington.scalgebra.ordered.OrderedEuclideanRing

  /**
    * The [[OrderedEuclideanRing]] instance describing the current algebra
    * system.
    */
  inline def orderedEuclideanRing[
    X : OrderedEuclideanRing as orderedEuclideanRing,
  ]: OrderedEuclideanRing[X] = orderedEuclideanRing
