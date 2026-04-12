package io.github.sgtswagrid.structures

import io.github.sgtswagrid.structures.builder.OneBuilder
import io.github.sgtswagrid.structures.ops.OneOps

/** For algebraic structures with a multiplicative identity (`one`). */
trait MultiplicativeIdentity[+X]:

  /**
    * The unique representation of the multiplicative identity (`1`) in this
    * algebra system. Typically corresponds to values such as `1` or `1.0F`.
    *
    * @note
    *   All implementations must obey the identity property, i.e.
    *   `x × one == one × x == x`.
    */
  def one: X

/**
  * The companion object for [[MultiplicativeIdentity]]. Import as
  * {{{
  * import io.github.sgtswagrid.structures.One.{*, given}
  * }}}
  * to receive all necessary syntax for working with one.
  */
object MultiplicativeIdentity extends OneBuilder, OneOps:

  export io.github.sgtswagrid.structures.MultiplicativeIdentity

  /**
    * The [[MultiplicativeIdentity]] instance describing the current algebra
    * system.
    */
  inline def multiplicativeIdentity[X : MultiplicativeIdentity as one]
    : MultiplicativeIdentity[X] = one
