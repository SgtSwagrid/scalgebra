package com.alecdorrington.scalgebra
package evidence
package collection

/** Evidence that [[LazyList]] forms an [[AdditiveMonoid]] under concatenation. */
trait LazyListIsAdditiveMonoid:

  given [X]: AdditiveMonoid[LazyList[X]] with

    override def zero: LazyList[X] = LazyList.empty

    override inline def add(x: LazyList[X], y: LazyList[X]): LazyList[X] = x ++
      y
