package com.alecdorrington.scalgebra
package evidence
package collection

import com.alecdorrington.scalgebra.normed.NormedAdditiveMonoid

/**
  * Evidence that [[Vector]] forms a [[NormedAdditiveMonoid]] under
  * concatenation, with norm given by the vector length.
  */
trait VectorIsNormedAdditiveMonoid:

  given [X] => NormedAdditiveMonoid[Vector[X], Int]:

    override def zero: Vector[X] = Vector.empty

    extension (x: Vector[X])

      override def add(y: Vector[X]): Vector[X] = x ++ y
      override def length: Int                  = x.length
