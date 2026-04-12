package io.github.sgtswagrid.structures
package ops

import io.github.sgtswagrid.structures.Semiring

/** Extension methods for [[Semiring]]. */
trait SemiringOps extends AdditiveMonoidOps, MultiplicativeMonoidOps:

  /** The unique representation of `2` in this algebra system. */
  def two[X : Semiring as X]: X = X.two
