package com.alecdorrington.scalgebra
package evidence
package collection

import com.alecdorrington.scalgebra.normed.NormedAdditiveMonoid

/**
  * Evidence that [[List]] forms a [[NormedAdditiveMonoid]] under concatenation,
  * with norm given by the list length.
  */
trait ListIsNormedAdditiveMonoid:

  given [X]: NormedAdditiveMonoid[List[X], Int] with

    override def zero: List[X]                               = Nil
    override inline def add(x: List[X], y: List[X]): List[X] = x ++ y
    override inline def norm(x: List[X]): Int                = x.length
