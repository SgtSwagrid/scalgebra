package io.github.sgtswagrid.structures
package evidence
package collection

import scala.reflect.ClassTag

/** Evidence that [[IArray]] forms an [[AdditiveMonoid]] under concatenation. */
trait IArrayIsAdditiveMonoid:

  given [X : ClassTag]: AdditiveMonoid[IArray[X]] with

    override def zero: IArray[X] = IArray.empty

    override inline def add(x: IArray[X], y: IArray[X]): IArray[X] = x ++ y
