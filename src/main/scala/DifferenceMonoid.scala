package io.github.sgtswagrid.structures

import io.github.sgtswagrid.structures.builder.DifferenceMonoidBuilder
import io.github.sgtswagrid.structures.ops.DifferenceMonoidOps

/** For algebraic structures with addition and subtraction. */
trait DifferenceMonoid[X] extends AdditiveMonoid[X]:

  /** Computes the difference between two values [[x]] and [[y]], i.e. `x - y`. */
  def subtract(x: X, y: X): X

/**
  * The companion object for [[DifferenceMonoid]]. Import as
  * ```scala
  * import io.github.sgtswagrid.structures.DifferenceMonoid.{*, given}
  * ```
  * to receive all necessary syntax for working with difference monoids.
  */
object DifferenceMonoid extends DifferenceMonoidBuilder, DifferenceMonoidOps:

  export io.github.sgtswagrid.structures.DifferenceMonoid

  /** The [[DifferenceMonoid]] instance describing the current algebra system. */
  inline def differenceMonoid[X : DifferenceMonoid as differenceMonoid]
    : DifferenceMonoid[X] = differenceMonoid
