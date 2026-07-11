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

  given [X : ClassTag] => NormedAdditiveMonoid[IArray[X], Int]:

    override def zero: IArray[X] = IArray.empty

    extension (x: IArray[X])

      override def add(y: IArray[X]): IArray[X] = x ++ y
      override def length: Int                  = x.size
