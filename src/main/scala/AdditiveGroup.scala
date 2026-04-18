package com.alecdorrington.scalgebra

import com.alecdorrington.scalgebra.builder.AdditiveGroupBuilder
import com.alecdorrington.scalgebra.ops.AdditiveGroupOps
import scala.reflect.ClassTag

/** For algebraic structures with addition and negation. */
trait  AdditiveGroup[X] extends DifferenceMonoid[X], AdditiveInverse[X]:

  override inline def subtract(x: X, y: X): X = add(x, negate(y))

  /** Computes [[x]] multiplied by [[n]], for any integer [[n]]. */
  override def scale(x: X, n: Int): X =
    super.scale(if n >= 0 then x else negate(x), n.abs)

/**
  * The companion object for [[AdditiveGroup]]. Import as
  * ```scala
  * import com.alecdorrington.scalgebra.AdditiveGroup.{*, given}
  * ```
  * to receive all necessary syntax for working with additive groups.
  */
object AdditiveGroup extends AdditiveGroupBuilder, AdditiveGroupOps:

  export com.alecdorrington.scalgebra.AdditiveGroup

  /** The [[AdditiveGroup]] instance describing the current algebra system. */
  inline def additiveGroup[X : AdditiveGroup as additiveGroup]
    : AdditiveGroup[X] = additiveGroup
