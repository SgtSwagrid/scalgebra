package com.alecdorrington.scalgebra
package lattice

/**
  * A typeclass for algebraic values with the following features:
  *   - Least element (`⊥`)
  */
trait JoinIdentity[X] extends Algebra[X]:

  /**
    * The unique least element `⊥` in this algebra, being the identity for
    * disjunction. Typically given by values such as `false` or `Set.empty`.
    */
  def bottom: X

  extension (x: X)

    /** @return `true` if and only if [[x]] equals [[bottom]]. */
    inline def isBottom: Boolean = x == bottom

    /** @return `true` if and only if [[x]] doesn't equal [[bottom]]. */
    inline def nonBottom: Boolean = x != bottom

object JoinIdentity:

  /**
    * The unique least element `⊥` in this algebra, being the identity for
    * disjunction. Typically given by values such as `false` or `Set.empty`.
    */
  inline def bottom[X : JoinIdentity as X]: X = X.bottom
