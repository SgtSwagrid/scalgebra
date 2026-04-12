package io.github.sgtswagrid.structures
package ordered

import io.github.sgtswagrid.structures.AdditiveIdentity
import io.github.sgtswagrid.structures.ordered.builder.OrderedAdditiveIdentityBuilder
import io.github.sgtswagrid.structures.ordered.ops.OrderedAdditiveIdentityOps

/** An ordered version of [[AdditiveIdentity]]. */
trait OrderedAdditiveIdentity[X] extends AdditiveIdentity[X], Ordering[X]:

  /** @return `true` if a value [[x]] is strictly positive, i.e. `x > 0`. */
  final inline def isPositive(x: X): Boolean = gt(x, zero)

  /** @return `true` if a value [[x]] is strictly negative, i.e. `x < 0`. */
  final inline def isNegative(x: X): Boolean = lt(x, zero)

  /** @return `true` if a value [[x]] is positive or [[zero]], i.e. `x ≥ 0`. */
  final inline def isNonNegative(x: X): Boolean = gteq(x, zero)

  /** @return `true` if a value [[x]] is negative or [[zero]], i.e. `x ≤ 0`. */
  final inline def isNonPositive(x: X): Boolean = lteq(x, zero)

/**
  * The companion object for [[OrderedAdditiveIdentity]]. Import as
  * {{{
  * import io.github.sgtswagrid.structures.ordered.OrderedAdditiveIdentity.{*, given}
  * }}}
  * to receive all necessary syntax for working with ordered additive identity.
  */
object OrderedAdditiveIdentity
  extends OrderedAdditiveIdentityBuilder, OrderedAdditiveIdentityOps:

  export io.github.sgtswagrid.structures.ordered.OrderedAdditiveIdentity

  /** The [[OrderedAdditiveIdentity]] instance describing the current algebra system. */
  inline def orderedAdditiveIdentity[
    X : OrderedAdditiveIdentity as orderedAdditiveIdentity,
  ]: OrderedAdditiveIdentity[X] = orderedAdditiveIdentity
