package com.alecdorrington.scalgebra
package evidence
package collection

import com.alecdorrington.scalgebra.normed.NormedAdditiveMonoid
import scala.reflect.ClassTag

/**
  * Evidence that [[IArray]] forms a [[NormedAdditiveMonoid]] under
  * concatenation, with norm given by the array length.
  */
trait IArrayIsNormedAdditiveMonoid:

  given [X : ClassTag]: NormedAdditiveMonoid[IArray[X], Int] with

    override def zero: IArray[X] = IArray.empty

    override inline def add(x: IArray[X], y: IArray[X]): IArray[X] = x ++ y

    override inline def norm(x: IArray[X]): Int = x.size
