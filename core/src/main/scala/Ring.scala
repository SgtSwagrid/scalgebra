package com.alecdorrington.scalgebra

import com.alecdorrington.scalgebra.builder.RingBuilder
import com.alecdorrington.scalgebra.ops.RingOps

/** For algebraic structures with addition, negation, and multiplication. */
trait Ring[X] extends AdditiveGroup[X], DifferenceSemiring[X]:

  /** The unique representation of `-1` in this algebra system. */
  def negativeOne: X = negate(one)

/**
  * The companion object for [[Ring]]. Import as
  * ```scala
  * import com.alecdorrington.scalgebra.Ring.{*, given}
  * ```
  * to receive all necessary syntax for working with rings.
  */
object Ring extends RingBuilder, RingOps:

  export com.alecdorrington.scalgebra.Ring

  /** The [[Ring]] instance describing the current algebra system. */
  inline def ring[X : Ring as ring]: Ring[X] = ring
