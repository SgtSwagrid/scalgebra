package io.github.sgtswagrid.structures

import io.github.sgtswagrid.structures.builder.MultiplicativeGroupBuilder
import io.github.sgtswagrid.structures.ops.MultiplicativeGroupOps

/** For algebraic structures with multiplication and reciprocation. */
trait MultiplicativeGroup[X]
  extends EuclideanMonoid[X], MultiplicativeInverse[X]:

  override inline def divide(x: X, y: X): X = multiply(x, reciprocate(y))

  /** Computes [[x]] raised to the power [[n]], for any integer [[n]]. */
  override def pow(x: X, n: Int): X =
    super.pow(if n >= 0 then x else reciprocate(x), n.abs)

/**
  * The companion object for [[MultiplicativeGroup]]. Import as
  * {{{
  * import io.github.sgtswagrid.structures.MultiplicativeGroup.{*, given}
  * }}}
  * to receive all necessary syntax for working with multiplicative groups.
  */
object MultiplicativeGroup
  extends MultiplicativeGroupBuilder, MultiplicativeGroupOps:

  export io.github.sgtswagrid.structures.MultiplicativeGroup

  /**
    * The [[MultiplicativeGroup]] instance describing the current algebra
    * system.
    */
  inline def multiplicativeGroup[X : MultiplicativeGroup as multiplicativeGroup]
    : MultiplicativeGroup[X] = multiplicativeGroup
