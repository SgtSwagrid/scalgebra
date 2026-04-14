package io.github.sgtswagrid.structures
package evidence
package collection

import scala.reflect.ClassTag

/** Evidence that [[Array]] forms an [[AdditiveMonoid]] under concatenation. */
trait ArrayIsAdditiveMonoid:

  given [X : ClassTag]: AdditiveMonoid[Array[X]] with

    override def zero: Array[X] = Array.empty

    override inline def add(x: Array[X], y: Array[X]): Array[X] = x ++ y
