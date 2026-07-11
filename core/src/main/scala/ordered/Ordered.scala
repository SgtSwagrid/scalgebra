package com.alecdorrington.scalgebra
package ordered

/**
  * A typeclass for algebraic values with the following features:
  *   - Total order
  */
trait Ordered[X] extends Ordering[X], Algebra[X]:

  extension (x: X)

    /**
      * @return
      *   `true` if and only if the left operand [[x]] is strictly smaller than
      *   the right [[y]].
      */
    inline infix def < (y: X): Boolean = compare(x, y) < 0

    /**
      * @return
      *   `true` if and only if the left operand [[x]] is not larger than the
      *   right [[y]].
      */
    inline infix def <= (y: X): Boolean = compare(x, y) <= 0

    /**
      * @return
      *   `true` if and only if the left operand [[x]] is strictly larger than
      *   the right [[y]].
      */
    inline infix def > (y: X): Boolean = compare(x, y) > 0

    /**
      * @return
      *   `true` if and only if the left operand [[x]] is not smaller than the
      *   right [[y]].
      */
    inline infix def >= (y: X): Boolean = compare(x, y) >= 0

    /** @return The lesser of both operands. */
    @annotation.targetName("minOf")
    infix def min(y: X): X = if x < y then x else y

    /** @return The greater of both operands. */
    @annotation.targetName("maxOf")
    infix def max(y: X): X = if x > y then x else y

    /**
      * Clamps [[x]] to lie within the inclusive range `[lb, ub]`.
      *
      * @return
      *   [[lb]] if `x < lb`, [[ub]] if `x > ub`, or [[x]] otherwise. If the
      *   range is degenerate, i.e. `lb > ub`, then [[x]] is returned unchanged.
      */
    def clamp(lb: X, ub: X): X =
      if lb > ub then x else if x < lb then lb else if x > ub then ub else x
