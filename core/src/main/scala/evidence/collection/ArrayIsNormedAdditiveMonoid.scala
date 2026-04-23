package com.alecdorrington.scalgebra
package evidence
package collection

import com.alecdorrington.scalgebra.normed.NormedAdditiveMonoid
import scala.reflect.ClassTag

/**
  * Evidence that [[Array]] forms a [[NormedAdditiveMonoid]] under
  * concatenation, with norm given by the array length.
  */
trait ArrayIsNormedAdditiveMonoid:

  given [X : ClassTag]: NormedAdditiveMonoid[Array[X], Int] with

    override def zero: Array[X]                                 = Array.empty
    override inline def add(x: Array[X], y: Array[X]): Array[X] = x ++ y
    override inline def norm(x: Array[X]): Int                  = x.length
