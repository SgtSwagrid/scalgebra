package com.alecdorrington.scalgebra
package evidence
package collection

import com.alecdorrington.scalgebra.normed.NormedAdditiveMonoid

/**
  * Evidence that [[LazyList]] forms a [[NormedAdditiveMonoid]] under
  * concatenation, with norm given by the list length.
  */
trait LazyListIsNormedAdditiveMonoid:

  given [X] => NormedAdditiveMonoid[LazyList[X], Int]:

    override def zero: LazyList[X] = LazyList.empty

    extension (x: LazyList[X])

      override def add(y: LazyList[X]): LazyList[X] = x ++ y
      override def length: Int                      = x.length
