package io.github.sgtswagrid.structures

import io.github.sgtswagrid.structures.builder.RingBuilder
import io.github.sgtswagrid.structures.ops.RingOps

/** For algebraic structures with addition, negation, and multiplication. */
trait Ring[X] extends AdditiveGroup[X], DifferenceSemiring[X]:

  /** The unique representation of `-1` in this algebra system. */
  def negativeOne: X = negate(one)

/**
  * The companion object for [[Ring]]. Import as
  * ```scala
  * import io.github.sgtswagrid.structures.Ring.{*, given}
  * ```
  * to receive all necessary syntax for working with rings.
  */
object Ring extends RingBuilder, RingOps:

  export io.github.sgtswagrid.structures.Ring

  /** The [[Ring]] instance describing the current algebra system. */
  inline def ring[X : Ring as ring]: Ring[X] = ring
