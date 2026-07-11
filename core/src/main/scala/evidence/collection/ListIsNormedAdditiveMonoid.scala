package com.alecdorrington.scalgebra
package evidence
package collection

import com.alecdorrington.scalgebra.normed.NormedAdditiveMonoid

/**
  * Evidence that [[List]] forms a [[NormedAdditiveMonoid]] under concatenation,
  * with norm given by the list length.
  */
trait ListIsNormedAdditiveMonoid:

  given [X] => NormedAdditiveMonoid[List[X], Int]:

    override def zero: List[X] = Nil

    extension (x: List[X])

      override def add(y: List[X]): List[X] = x ++ y
      override def length: Int              = x.length
