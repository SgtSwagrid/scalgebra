package com.alecdorrington.scalgebra
package evidence
package collection

import com.alecdorrington.scalgebra.normed.NormedAdditiveMonoid

/**
  * Evidence that [[Option]] forms a [[NormedAdditiveMonoid]] by lifting an
  * [[AdditiveSemigroup]], with norm given by the number of elements (`0` for
  * [[None]], `1` for [[Some]]).
  */
trait OptionIsNormedAdditiveMonoid:

  given [X : AdditiveSemigroup as X]: NormedAdditiveMonoid[Option[X], Int] with

    override def zero: Option[X] = None

    override def add(x: Option[X], y: Option[X]): Option[X] = (x, y) match
      case (None, _)          => y
      case (_, None)          => x
      case (Some(a), Some(b)) => Some(X.add(a, b))

    override inline def norm(x: Option[X]): Int = x.size
