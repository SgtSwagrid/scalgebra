package com.alecdorrington.scalgebra
package ordered

/** An ordered version of [[Euclidean]]. */
trait OrderedEuclidean[X] extends Euclidean[X], Order[X]

/** The companion object for [[OrderedEuclidean]]. */
object OrderedEuclidean extends OrderedEuclidean.Ops:

  trait Ops extends Euclidean.Ops

  export com.alecdorrington.scalgebra.ordered.OrderedEuclidean

  /** The [[OrderedEuclidean]] instance describing the current algebra system. */
  inline def orderedEuclidean[X : OrderedEuclidean as orderedEuclidean]
    : OrderedEuclidean[X] = orderedEuclidean
