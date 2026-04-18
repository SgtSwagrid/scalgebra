package com.alecdorrington.scalgebra
package ordered

import com.alecdorrington.scalgebra.EuclideanRing
import com.alecdorrington.scalgebra.ordered.builder.OrderedEuclideanRingBuilder
import com.alecdorrington.scalgebra.ordered.ops.OrderedEuclideanRingOps

/** An ordered version of [[EuclideanRing]]. */
trait OrderedEuclideanRing[X]
  extends EuclideanRing[X], OrderedRing[X], OrderedEuclideanMonoid[X]

/**
  * The companion object for [[OrderedEuclideanRing]]. Import as
  * ```scala
  * import com.alecdorrington.scalgebra.ordered.OrderedEuclideanRing.{*, given}
  * ```
  * to receive all necessary syntax for working with ordered Euclidean rings.
  */
object OrderedEuclideanRing
  extends OrderedEuclideanRingBuilder, OrderedEuclideanRingOps:

  export com.alecdorrington.scalgebra.ordered.OrderedEuclideanRing

  /**
    * The [[OrderedEuclideanRing]] instance describing the current algebra
    * system.
    */
  inline def orderedEuclideanRing[
    X : OrderedEuclideanRing as orderedEuclideanRing,
  ]: OrderedEuclideanRing[X] = orderedEuclideanRing
