package com.alecdorrington.scalgebra
package lattice

/**
  * A typeclass for algebraic values with the following features:
  *   - Greatest element (`⊤`)
  */
trait MeetIdentity[X] extends Algebra[X]:

  /**
    * The unique greatest element `⊤` in this algebra, being the identity for
    * conjunction. Typically given by values such as `true`.
    */
  def top: X

  extension (x: X)

    /** @return `true` if and only if [[x]] equals [[top]]. */
    inline def isTop: Boolean = x == top

    /** @return `true` if and only if [[x]] doesn't equal [[top]]. */
    inline def nonTop: Boolean = x != top

object MeetIdentity:

  /**
    * The unique greatest element `⊤` in this algebra, being the identity for
    * conjunction. Typically given by values such as `true`.
    */
  inline def top[X : MeetIdentity as X]: X = X.top
