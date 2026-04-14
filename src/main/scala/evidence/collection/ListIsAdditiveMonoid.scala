package io.github.sgtswagrid.structures
package evidence
package collection

/** Evidence that [[List]] forms an [[AdditiveMonoid]] under concatenation. */
trait ListIsAdditiveMonoid:

  given [X]: AdditiveMonoid[List[X]] with

    override def zero: List[X]                               = Nil
    override inline def add(x: List[X], y: List[X]): List[X] = x ++ y
