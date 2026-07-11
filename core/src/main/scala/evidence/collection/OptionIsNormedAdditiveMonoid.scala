package com.alecdorrington.scalgebra
package evidence
package collection

import com.alecdorrington.scalgebra.arithmetic.AdditiveSemigroup
import com.alecdorrington.scalgebra.normed.NormedAdditiveMonoid

/**
  * Evidence that [[Option]] forms a [[NormedAdditiveMonoid]] by lifting an
  * [[AdditiveSemigroup]], with norm given by the number of elements (`0` for
  * [[None]], `1` for [[Some]]).
  */
trait OptionIsNormedAdditiveMonoid:

  given [X : AdditiveSemigroup as X] => NormedAdditiveMonoid[Option[X], Int]:

    override def zero: Option[X] = None

    extension (x: Option[X])

      override def add(y: Option[X]): Option[X] = (x, y) match
        case (None, _)          => y
        case (_, None)          => x
        case (Some(a), Some(b)) => Some(a + b)
      override def length: Int = x.size
