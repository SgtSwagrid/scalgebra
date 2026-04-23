package com.alecdorrington.scalgebra
package evidence
package collection

import com.alecdorrington.scalgebra.normed.NormedAdditiveMonoid

/**
  * Evidence that [[LazyList]] forms a [[NormedAdditiveMonoid]] under
  * concatenation, with norm given by the list length.
  */
trait LazyListIsNormedAdditiveMonoid:

  given [X]: NormedAdditiveMonoid[LazyList[X], Int] with

    override def zero: LazyList[X] = LazyList.empty

    override inline def add(x: LazyList[X], y: LazyList[X]): LazyList[X] = x ++
      y

    override inline def norm(x: LazyList[X]): Int = x.length
