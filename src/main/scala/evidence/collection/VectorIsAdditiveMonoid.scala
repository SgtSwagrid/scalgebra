package io.github.sgtswagrid.structures
package evidence
package collection

/** Evidence that [[Vector]] forms an [[AdditiveMonoid]] under concatenation. */
trait VectorIsAdditiveMonoid:

  given [X]: AdditiveMonoid[Vector[X]] with

    override def zero: Vector[X] = Vector.empty
    override inline def add(x: Vector[X], y: Vector[X]): Vector[X] = x ++ y
