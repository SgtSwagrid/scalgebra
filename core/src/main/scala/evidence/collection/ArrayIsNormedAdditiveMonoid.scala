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

  given [X : ClassTag] => NormedAdditiveMonoid[Array[X], Int]:

    override def zero: Array[X] = Array.empty

    extension (x: Array[X])

      override def add(y: Array[X]): Array[X] = x ++ y
      override def length: Int                = x.length
