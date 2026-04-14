package io.github.sgtswagrid.structures

import io.github.sgtswagrid.structures.builder.SemifieldBuilder
import io.github.sgtswagrid.structures.ops.SemifieldOps

/** For algebraic structures with addition, multiplication, and reciprocation. */
trait Semifield[X] extends Semiring[X], MultiplicativeGroup[X]

/**
  * The companion object for [[Semifield]]. Import as
  * ```scala
  * import io.github.sgtswagrid.structures.Semifield.{*, given}
  * ```
  * to receive all necessary syntax for working with semifields.
  */
object Semifield extends SemifieldBuilder, SemifieldOps:

  export io.github.sgtswagrid.structures.Semifield

  /** The [[Semifield]] instance describing the current algebra system. */
  inline def semifield[X : Semifield as semifield]: Semifield[X] = semifield
