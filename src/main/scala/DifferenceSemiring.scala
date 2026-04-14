package io.github.sgtswagrid.structures

import io.github.sgtswagrid.structures.builder.DifferenceSemiringBuilder
import io.github.sgtswagrid.structures.ops.DifferenceSemiringOps

/** For algebraic structures with addition, subtraction, and multiplication. */
trait DifferenceSemiring[X] extends Semiring[X], DifferenceMonoid[X]

/**
  * The companion object for [[DifferenceSemiring]]. Import as
  * ```scala
  * import io.github.sgtswagrid.structures.DifferenceSemiring.{*, given}
  * ```
  * to receive all necessary syntax for working with difference semirings.
  */
object DifferenceSemiring
  extends DifferenceSemiringBuilder, DifferenceSemiringOps:

  export io.github.sgtswagrid.structures.DifferenceSemiring

  /** The [[DifferenceSemiring]] instance describing the current algebra system. */
  inline def differenceSemiring[X : DifferenceSemiring as differenceSemiring]
    : DifferenceSemiring[X] = differenceSemiring
