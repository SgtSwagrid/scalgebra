package com.alecdorrington.scalgebra
package evidence
package collection

import com.alecdorrington.scalgebra.normed.NormedAdditiveMonoid

/**
  * Evidence that [[Vector]] forms a [[NormedAdditiveMonoid]] under
  * concatenation, with norm given by the vector length.
  */
trait VectorIsNormedAdditiveMonoid:

  given [X]: NormedAdditiveMonoid[Vector[X], Int] with

    override def zero: Vector[X] = Vector.empty
    override inline def add(x: Vector[X], y: Vector[X]): Vector[X] = x ++ y
    override inline def norm(x: Vector[X]): Int                    = x.length
